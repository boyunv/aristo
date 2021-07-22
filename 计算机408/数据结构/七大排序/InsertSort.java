//主要编写核心代码
//核心思想:假设按正序来排序-第一次:将第二个元素b与第一个元素a进行比较,如果a>b,进行交换,然后将第三个元素与第二个元素比较,若小于,交换,再与第一个比较重复上述步骤至全部完成
public  class  InsertSort{
      
  //插入排序
  public  void sort(int[] arr){
      //1.判断合法性
    if(arr==null){
        throw new RuntimeException("数组为空,请冲洗输入");
    }
    //2.数组的长度
    int len=arr.length;
    //遍历循环将
    for(int i=0;i<len;i++){
      //3.temp代表找到值后的交换数值,做个临时存储的作用
      int temp=arr[i];
      int j=i;
      while(j>0&&arr[j-1]>arr[j]){
        arr[j]=arr[j-1];
        j--;
      }
      arr[j]=temp;
    }
  }
    
    
}
