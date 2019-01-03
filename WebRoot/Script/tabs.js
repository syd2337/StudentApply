/*
 * 分页 查看内容有几条，定为一页有二十条，计算一共有几页，一开始展示前二十条。上一页1（pageNo当前页码）/20（totalPage总页码）下一页
 * 点击上一页判断当前页码是否小于等于1，是的话为不能点击，否则可以点击展示内容pageNo-1for（（i=（pageNo-2）*20）;i<=(pageNo-1)*20-1；i++）
 * 点击下一页判断当前页码是否大于等于总页码，是的话不能点击，否则的话点击展示内容pageNo+1
 * if(pageNo+1=totalPage)for((i=pageNo+1)*20;i<=pageTotal-1;i++)
 * for((i=pageNo+1)*20;i<=(pageNo+2)*20-1;i++)
 * 
 */
// 上一页
var totalPage;
//总页数
var pageNo;
function theFir() {
	pageNo = $("#pageNo").html();
	totalPage = $("#totalPage").html();
	if(pageNo==null||pageNo==""||pageNo==1){
		alert("已是第一页了");
		return;
	}
	pageNo = 1;
	window.location.href = 'student.html?pageNo='+pageNo
	}

function theEnd() {
	pageNo = $("#pageNo").html();
	totalPage = $("#totalPage").html();
	if(pageNo==null||pageNo==""||pageNo==totalPage){
		alert("已是最后一页");
		return;
	}
	pageNo = totalPage;
	window.location.href = 'student.html?pageNo='+pageNo
	}

//获取当前页码
function up() {
	pageNo = $("#pageNo").html();
	if (pageNo == 1) {
		alert("已是第一页了");
	} else {
		pageNo = pageNo - 1;
		window.location.href = 'student.html?pageNo='+pageNo
	}
}
// 下一页
function down() {
	// alert(totalPage+"klll"+pageNo)
	pageNo = $("#pageNo").html();
	totalPage = $("#totalPage").html();
	console.log(pageNo + totalPage);
	if (parseInt(pageNo) < parseInt(totalPage)) {
		pageNo = parseInt(pageNo) + 1;
		window.location.href = 'student.html?pageNo='+pageNo
	} else {
		alert("已是最后一页");
	}
}
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
function method5(tableid) {  
    if(getExplorer()=='ie')  
    {  
        var curTbl = document.getElementById(tableid);  
        var oXL = new ActiveXObject("Excel.Application");  
        var oWB = oXL.Workbooks.Add();  
        var xlsheet = oWB.Worksheets(1);  
        var sel = document.body.createTextRange();  
        sel.moveToElementText(curTbl);  
        sel.select();  
        sel.execCommand("Copy");  
        xlsheet.Paste();  
        oXL.Visible = true;  
			var fname='';
        try {  
            fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");  
        } catch (e) {  
            print("Nested catch caught " + e);  
        } finally {  
            oWB.SaveAs(fname);  
            oWB.Close(savechanges = false);  
            oXL.Quit();  
            oXL = null;  
            idTmr = window.setInterval("Cleanup();", 1);  
        }  

    }  
    else  
    {  
        tableToExcel(tableid);  
    }  
}  
function Cleanup() {  
    window.clearInterval(idTmr);  
    CollectGarbage();  
}  
var tableToExcel = (function() {  
    var uri = 'data:application/vnd.ms-excel;base64,',  
            template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',  
            base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))); },  
            format = function(s, c) {  
                return s.replace(/{(\w+)}/g,  
                        function(m, p) { return c[p]; }); };  
    return function(table, name) {  
        if (!table.nodeType) table = document.getElementById(table);  
        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML};  
        window.location.href = uri + base64(format(template, ctx)); 
    };  
})();  