class Solution {
    public void duplicateZeros(int[] arr) {
       int[] res = new int[arr.length];
       int index=0;
       for(int i=0;i<arr.length && index<arr.length; i++)
       {
        if(arr[i]==0)
        {
            index+=2;
        }else{

            res[index]=arr[i];
            index++;
        }
       } 
       for(int i=0;i<res.length;i++)
       {
        arr[i]=res[i];
       }
    }
}