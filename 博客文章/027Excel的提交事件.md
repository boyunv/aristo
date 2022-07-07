# Excel_submit

```JavaScript
 function excel_submit(e) {        
	UCRealgrid.Commit(true);
        ucInsertRealgrid.Commit(true);

        if (e.target.value.length > 0) {
            var gFileExcel = e.target.value.split('.');
            if (gFileExcel[gFileExcel.length - 1] == "xls") {

                // message (10031) : 입력할 엑셀 파일을 선택하세요.
                xAlert("[XLSX] " + '<%=lang.message["10031"]%>');
                return;
            }
            else {
                $("#txt_excel_path").val(e.target.value);
            };
        };

        /// <summary>엑셀 파일을 읽어 들여 그리드에 표시한다.</summary>       
        var rABS = typeof FileReader != "undefined" && (FileReader.prototype || {}).readAsBinaryString;
        //var file = f.value;
        var f = e.target.files[0];
        var reader = new FileReader();
        //var result = [];

        reader.onload = function (e) {
            var data = e.target.result;
            if (!rABS) data = new Uint8Array(data);
            var workbook = XLSX.read(data, { type: rABS ? 'binary' : 'array' });

            var sheet_name_list = workbook.SheetNames;
            sheet_name_list.forEach(function (y) {
                var roa = XLSX.utils.sheet_to_json(workbook.Sheets[y], { header: 1 });
                if (roa.length > 1) {

                    // 대만 법인 컬럼이 8개로 늘어서(코팅LOT 컬럼 추가)
                    if (roa[0].length < 7 || roa[0].length > 12) {
                        // message (25114) : 지정된 양식을 사용하시기 바랍니다.
                        xAlert('<%=lang.message["25114"]%>');
                        return;
                    }

                    var getRows = [];
                    var getSubRows = [];
                    var colFind = 7;
                    //20190327 김정태 수정 했음. 
                    //var colMax = ($("[id$=hidShopID]").val() != "G221") ? 6 : 8; // 대만법인 코팅LOT 컬럼 추가
                    var colMax = 7;
                    if ($("[id$=hidShopID]").val() == "G221") {
                        colMax = 8;
                    }
                    if ($("[id$=hidShopID]").val() == "G572") {
                        colMax = 12;
                    }
                    var colLang = "<%=lang.word["Trade Type"]%>";
                    var rtnLang = "";
                    var getColNM = "";
                    var getColCnt = 0;

                    for (var i = 0; i < roa.length; i++) {

                        if (i == 0) {

                            for (var j = 0; j < roa[i].length; j++) {

                                if (colLang == roa[i][j]) {
                                    colFind = j;
                                };
                            };
                        } else {
                            getSubRows = [];
                            getColCnt = 0;

                            var bExistLot = false;
                            // 제품코드와 공급사 LOTID가 엑셀양식에 없다면...추가하지 않는다.
                            if ((roa[i][0] != undefined) && (roa[i][1] != undefined)) {

                                for (var j = 0; j < roa[i].length; j++) {

                                    getColNM = $.trim(roa[i][j]);
                                    if (j == 1)     // 구매 Lot 인 경우 이미 Grid에 추가되어 있으면 Skip
                                    {
                                        ucInsertRealgrid_dataProvider.getJsonRows(0, -1).forEach(function (value, index, array) {

                                            if (getColNM == value.SUPPLIER_LOTID) {
                                                bExistLot = true;
                                            };
                                        });
                                        if (bExistLot) break;   // 존재하는 LOT일 경우 break
                                    }

                                    if (getColNM == undefined) {

                                        getColCnt++;
                                        getSubRows.push("");
                                    } else {

                                        if (getColNM.trim().length <= 0) {

                                            getColCnt++;
                                            getSubRows.push("");
                                        } else {
                                            // 대상컬럼이 "무역구분" 이리면 한글(중국어)를 가지고 코드로 치환해 준다... 공백리턴 시 값 그대로 사용..
                                            //if (j == colFind) {
                                                //2018-10-18 북경일 경우 WP20무상 BS,  G241유상일 경우 YM 
                                            if ($("[id$=hidShopID]").val() == "G241" && j == (colFind - 2)) {
                                                    getSubRows.push("YM"); //일반무역 ERP저장위치에 대한 처리 필요
                                                }
                                                else if ($("[id$=hidShopID]").val() == "WP20" && j == (colFind - 2)) {
                                                    getSubRows.push("BS"); //보세
                                                }
                                                // 대만
                                                else if ($("[id$=hidShopID]").val() == "G221" && j == (colFind - 2)) {
                                                    getSubRows.push("2000|YM"); //일반무역
                                                }
                                                else if (j == (colFind - 2)) {
                                                    var tmpSplit = getChangeTrade(getColNM);
                                                    getSubRows.push(tmpSplit);
                                                }
                                        //} 
                                                else if (j == (colFind - 1)) {
                                                    if ($("[id$=hidShopID]").val() == "G181") {
                                                        var tmpSplit2 = getChangeTrade2(getColNM);
                                                        getSubRows.push(tmpSplit2);
                                                    }
                                                    else {
                                                        var tmpSplit = getChangeTrade(getColNM);
                                                        getSubRows.push(tmpSplit);
                                                    }
                                                }
                                            else {
                                                getSubRows.push(getColNM);
                                            };

                                            // 엑셀파일에 6(대만은 8개)개컬럼을 다 체우지 못하고 모자란다면... 모자란 컬럼만큼 공백을 채워준다.
                                            // 안그러면 무역구분 콤보 내용일 안보일 수 있다.
                                            if ((j == roa[i].length - 1) && (j < colMax)) {
                                                for (var k = (j + 1) ; k <= colMax; k++) {
                                                    getSubRows.push("");
                                                };
                                            };
                                        };
                                    };
                                    
                                };

                                if (!bExistLot && getColCnt < roa[i].length) {      // Grid에 존재하는 LOT이 아닌 경우
                                    //getSubRows.push(rtnSloc);
                                    getRows.push(getSubRows);   
                                };
                            };
                        };
                    };
                    if (getRows.length > 0)
                        recordConfiguration(getRows);
                };
            });
        };

        if (rABS) {
            reader.readAsBinaryString(f);
        } else {
            reader.readAsArrayBuffer(f);
        };

        _IsExcelClearKey = true;
        $('#uploadFile').val("");
    };
```