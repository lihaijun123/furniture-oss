function showRemind(){
	var tab = document.getElementById("list00_rectable");
	var row = tab.insertRow(-1);
	var cell = row.insertCell(-1);
	cell.innerHTML="<span style='color:red'>默認為最近一個月的數據，如需查看更多，請搜索。</span>";
}

UITool.AddEventHandler(window,"load",showRemind);