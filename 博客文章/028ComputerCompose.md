```shell

        function PrintZebraBJ(parm) {
            if (parm) {
                var chkRows = UCRealgrid_gridView.getCheckedRows();
                var lblItemsArray = new Array();
                var lblItems = [];

                var getEqsgTitle = $("#cbo_Line").combobox('getText').split(']');

                var getEqsgTitleVal = getEqsgTitle[getEqsgTitle.length - 1];

                if (getEqsgTitleVal.length <= 0) {
                    getEqsgTitleVal = $("#cbo_Line").combobox('getText');
                };

                var AreaID = $('#cbo_Area').combobox('getValue');   // 2020-12-28 북경 무상 Shop 관련 처리 (북경 무상 동이 북경유상(G241)로 변경

                var vITEM0236 = "";
                if ($("[id$=hidShopID]").val() == "G241") {
                    if (AreaID == "WP2001" || AreaID == "WP2002")
                        vITEM0236 = "韩国";
                    else
                        vITEM0236 = "南京";
                }
                else if ($("[id$=hidShopID]").val() == "WP20") {
                    vITEM0236 = "韩国";
                }

                for (var i = 0; i < chkRows.length; i++) {

                    var currentJsonRow = UCRealgrid_dataProvider.getJsonRow(chkRows[i]);
///===================
//规定数据:
                    lblItems = [];
                    lblItems = [
                        { PRTITEMID: "ITEM0031", VALUE: (currentJsonRow.EQSGNAME != undefined) ? currentJsonRow.EQSGNAME : getEqsgTitleVal }     // 창고명
                        , { PRTITEMID: "ITEM0236", VALUE: vITEM0236 }                                                                              // 공장구분
                        , { PRTITEMID: "ITEM0032", VALUE: currentJsonRow.LBL_INCOMING_DAY }                                                        // 입고일자                                            
                        , { PRTITEMID: "ITEM0189", VALUE: (currentJsonRow.EXPDECLRNO != undefined) ? currentJsonRow.EXPDECLRNO : '' }              // 수책번호
                        , { PRTITEMID: "ITEM0192", VALUE: (currentJsonRow.EXPDECLRHANGNO != undefined) ? currentJsonRow.EXPDECLRHANGNO : '' }      // 수책항목번호
                        , { PRTITEMID: "ITEM0001", VALUE: (currentJsonRow.MTRLIDNAME != undefined) ? currentJsonRow.MTRLIDNAME : '' }              // 제품명
                        , { PRTITEMID: "ITEM0003", VALUE: (currentJsonRow.MTRLID != undefined) ? currentJsonRow.MTRLID : '' }                      // 제품코드
                        , { PRTITEMID: "ITEM0009", VALUE: (currentJsonRow.MTRLUNIT != undefined) ? currentJsonRow.MTRLUNIT : '' }                  // 수량단위
                        , { PRTITEMID: "ITEM0008", VALUE: (currentJsonRow.MLOTQTY_STOCKED_COMMA != undefined) ? currentJsonRow.MLOTQTY_STOCKED_COMMA : '' }    // 수량
                        , { PRTITEMID: "ITEM0002", VALUE: (currentJsonRow.SIZE != undefined) ? currentJsonRow.SIZE : '' }                          // 제품ID 사이즈
                        , { PRTITEMID: "ITEM0043", VALUE: (currentJsonRow.SUPPLIER_LOTID != undefined) ? currentJsonRow.SUPPLIER_LOTID : '' }      // 공급사 LOTID
                        , { PRTITEMID: "ITEM0007", VALUE: (currentJsonRow.MLOTID != undefined) ? currentJsonRow.MLOTID : '' }                      // 원재료 LOTID
                        , { PRTITEMID: "ITEM0049", VALUE: (currentJsonRow.MLOTID != undefined) ? currentJsonRow.MLOTID : '' }                      // 원재료 LOTID (바코드) 
                    ];

                    lblItemsArray.push(lblItems);
                };

                try {
                  //什么叫做计算机?
        	/////有处理器和内存的机器就是计算机=========
        	////计算机中存储器非常多,满足人们的需求,速度快,存储大,便宜=================
        	//===运算器,存储器,控制器,输入输出,总线
        	//运算器:进行一次基本的算术逻辑运算
        		   计算机字长,位数越高,精度越高
               //存储器存储的东西:就是信息,程序和数据(都是二进制代码)====>如何用二进制来表示五花八门的世界
               ////====存储元(就是一个一位二进制数)1bit
               //========存储单元:若干个存储元组合成一个集合!B=8bit====>存储单元的编号:地址(入我们的寝室号)
               //存储容量:强调一个字节1B=8bit(8位二进制数)  如存储器为64B=64*8bit    1K=2^10  表示容量和速度是不一样的
               //=================
               //控制器:电脑的大脑(为人服务,相比较起的是被动)执行我们
               //规定程序的
               //对各种异常情况进行及时的响应处理
               //计算机逻辑运算器只能叫
        	
                    if ($("[id$=hidShopID]").val() == "G241") {
                        PrintLabelMulti("LBJ1MT00011", lblItemsArray);
                    }
                    else if ($("[id$=hidShopID]").val() == "WP20") {
                        PrintLabelMulti("LBJ2MT00011", lblItemsArray);
                    }

                    PrintStr = "Y";

                    if (UCRealgrid_dataProvider.getJsonRow(chkRows[0]).SECTION != "P")  // 원자재(ROLL)경우만 발행 BizActor 처리
                        PrintProc(true);    //발행여부 "Y" 처리

                    // 체크된 데이터 체크 해제
                    //if (UCRealgrid_gridView.getCheckedRows().length > 0) {                                                                    
                    //    UCRealgrid_gridView.checkAll(false, false);
                    //};
                }
                catch (e) {
                    // message (20152) : 라벨 스크립트를 확인할 수 없습니다.
                    xAlert('<%=lang.message["20152"]%>');
                };
            };
        };
      
```

