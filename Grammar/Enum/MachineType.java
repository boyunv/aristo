package com.zf.cas.domain.define;
public enum MachineType{
    //牛羊肉
  REDMEAT(1),
  //手工菜
  HANDMADE(2),
  //小吃
  SNACK(3),
  //配锅
  POT(4),
  //备菜
  STOCK(5),
  //配菜线
  DISH_LINE(6),
  //配锅线
  POT_LINE(7),
  //备菜线
  STOCK_LINE(8),
  //提升机线
  ELEVATOR_LINE(9);
  
  //进行枚举值的绑定操作
  private int value;
  MachineType(int value){
    this.value=value;
  }
  public static MachineType  getItemByValue(int value){
    MachineType  type=null;
    for(MachineType  item:MachineType.values()){
        if(item.value==value){
            type=item;
            break;
        }
    }
    return type;
  
  }
  


}
