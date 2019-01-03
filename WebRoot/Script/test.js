var idTmr;
        function  getExplorer() {
            var explorer = window.navigator.userAgent ;
            //ie
            if (explorer.indexOf("MSIE") >= 0) {
                return 'ie';
            }
            //firefox
            else if (explorer.indexOf("Firefox") >= 0) {
                return 'Firefox';
            }
            //Chrome
            else if(explorer.indexOf("Chrome") >= 0){
                return 'Chrome';
            }
            //Opera
            else if(explorer.indexOf("Opera") >= 0){
                return 'Opera';
            }
            //Safari
            else if(explorer.indexOf("Safari") >= 0){
                return 'Safari';
            }
        }
        function method1(tableid) {//������񿽱���EXCEL��
            if(getExplorer()=='ie') {
                var curTbl = document.getElementById(tableid);
                var oXL = new ActiveXObject("Excel.Application");

                //����AX����excel
                var oWB = oXL.Workbooks.Add();
                //��ȡworkbook����
                var xlsheet = oWB.Worksheets(1);
                //���ǰsheet
                var sel = document.body.createTextRange();
                sel.moveToElementText(curTbl);
                //�ѱ���е������Ƶ�TextRange��
                sel.select;
                //ȫѡTextRange������
                sel.execCommand("Copy");
                //����TextRange������
                xlsheet.Paste();
                //ճ�������EXCEL��
                oXL.Visible = true;
                //����excel�ɼ�����

                try {
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
                } catch (e) {
                    print("Nested catch caught " + e);
                } finally {
                    oWB.SaveAs(fname);

                    oWB.Close(savechanges = false);
                    //xls.visible = false;
                    oXL.Quit();
                    oXL = null;
                    //����excel���̣��˳����
                    //window.setInterval("Cleanup();",1);
                    idTmr = window.setInterval("Cleanup();", 1);
                }
            } else {
                tableToExcel('ta')
            }
        }
        function Cleanup() {
            window.clearInterval(idTmr);
            CollectGarbage();
        }

        /*
            template �� �����ĵ������ͣ��൱��htmlҳ���ж�����<!DOCTYPE> ��������������⣬��ȷ����
            encodeURIComponent:����
            unescape() ��������ͨ�� escape() ������ַ������н��롣
            window.btoa(window.encodeURIComponent(str)):֧�ֺ��ֽ��н��롣
            \w ��ƥ������»��ߵ��κε����ַ����ȼ��ڡ�[A-Za-z0-9_]��
            replace()�������������ַ�������һЩ�ַ��滻��һЩ�ַ������滻һ����������ʽƥ����Ӵ���
            {(\w+)}��ƥ������ {1��������ַ�} ��ʽ���ַ������˴�ƥ����������� ��worksheet��
            �����е�() ����Ϊ����ȡƥ����ַ��������ʽ���м���()���м�����Ӧ��ƥ���ַ�����
            ����(/{(\w+)}/g, function(m, p) { return c[p]; } ��
                /{(\w+)}/g ƥ���������ʽΪ��{worksheet}�����ַ�����
                function������  m  ������ƥ�䵽�����ݣ�����worksheet����
                                p  ������ʽ�з��������,����(\w+)��������ƥ�䵽�����ݣ�Ϊ��worksheet����
                c ��Ϊobject������ͼ3
                c[p] : Ϊ��worksheet��

        */
        var tableToExcel = (function() {
            var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64 = function(s) {
                return window.btoa(unescape(encodeURIComponent(s)))
            },
            // ������κ��������ǣ���template�еı����滻Ϊҳ������ctx��ȡ����ֵ
            format = function(s, c) {
                    return s.replace(/{(\w+)}/g,
                                    function(m, p) {
                                        return c[p];
                                    }
                    )
            };
            return function(table, name) {
                if (!table.nodeType) {
                    table = document.getElementById(table)
                }
                // ��ȡ�������ֺͱ���ѯ������
                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML};
                // format()������ͨ����ʽ����ʹ�������͵�����ת����һ���ַ���
                // base64()�����б���
                window.location.href = uri + base64(format(template, ctx))
            }
        })()