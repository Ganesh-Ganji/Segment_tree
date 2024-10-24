public class Segment {
    private int[] node;
    Segment(int n){
        node=new int[4*n];
    }
    public void build(int idx,int[] ar,int low,int high){
        if(low==high){
            node[idx]=ar[low];
            return;
        }
        int mid=low+(high-low)/2;
        build(2*idx+1,ar,low,mid);
        build(idx*2+2,ar,mid+1,high);
        node[idx]=Math.max(node[idx*2+1],node[2*idx+2]);
    }
    public int query(int idx,int low,int high,int l,int r){
        if(high<l || r<low){
            return Integer.MIN_VALUE;
        }
        if(l<=low && high<=r){
            return node[idx];
        }
        int mid=low+(high-low)/2;
        int left=query(idx*2+1,low,mid,l,r);
        int right=query(idx*2+2,mid+1,high,l,r);
        return Math.max(left,right);
    }

    public void update(int idx,int[] ar,int low,int high,int i,int val){
        if(low==high){
            ar[i]=val;
            node[idx]=val;
            return;
        }
        int mid=low+(high-low)/2;
        if(i<=mid){
            update(idx*2+1,ar,low,mid,i,val);
        }
        else{
            update(idx*2+2,ar,mid+1,high,i,val);
        }
        node[idx]=Math.max(node[idx*2+1],node[2*idx+2]);
    }
}





















