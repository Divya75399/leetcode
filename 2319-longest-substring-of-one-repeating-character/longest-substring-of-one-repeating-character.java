class Solution {
    class Node {
        int lmx, rmx, mx, len;
        char lc, rc;
    }

    Node[] tree;
    char[] arr;

    Node merge(Node a, Node b) {
        Node c = new Node();
        c.len = a.len + b.len;
        c.lc = a.lc;
        c.rc = b.rc;

        c.lmx = a.lmx;
        if (a.lmx == a.len && a.rc == b.lc)
            c.lmx = a.len + b.lmx;

        c.rmx = b.rmx;
        if (b.rmx == b.len && a.rc == b.lc)
            c.rmx = b.len + a.rmx;

        c.mx = Math.max(a.mx, b.mx);
        if (a.rc == b.lc)
            c.mx = Math.max(c.mx, a.rmx + b.lmx);

        return c;
    }

    void build(int idx, int l, int r) {
        tree[idx] = new Node();

        if (l == r) {
            tree[idx].len = tree[idx].lmx = tree[idx].rmx = tree[idx].mx = 1;
            tree[idx].lc = tree[idx].rc = arr[l];
            return;
        }

        int m = (l + r) / 2;
        build(idx * 2, l, m);
        build(idx * 2 + 1, m + 1, r);
        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    void update(int idx, int l, int r, int pos, char val) {
        if (l == r) {
            arr[pos] = val;
            tree[idx].lc = tree[idx].rc = val;
            return;
        }

        int m = (l + r) / 2;
        if (pos <= m)
            update(idx * 2, l, m, pos, val);
        else
            update(idx * 2 + 1, m + 1, r, pos, val);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].mx;
        }

        return ans;
    }
}