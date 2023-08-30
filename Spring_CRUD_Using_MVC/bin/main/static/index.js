function callApi(METHOD, URL, DATA, SUCCESS) {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open(METHOD, URL, true);
  xmlhttp.setRequestHeader('Content-type', 'application/json');
  xmlhttp.onreadystatechange = function() {
    if (this.readyState === 4) {
      if (this.status === 200) {
        SUCCESS(this.responseText);
      } else {
        alert("404: error");
      }
    }
  };
  xmlhttp.send(DATA);
}

function register() {
  var url = "http://localhost:8080/hello/insert";
  var data = JSON.stringify({
    "id": t1.value,
    "name": t2.value,
    "number": t3.value,
    "amount": t4.value,
    "status": d1.options[d1.selectedIndex].value
  });
  callApi("POST", url, data, getResponse);
}

function update(){
	var url = "http://localhost:8080/hello/update/"+t1.value+"/"+t4.value;
	callApi("PUT",url,"",getResponse)
	
}

function deleteData(){
	var url= "http://localhost:8080/hello/delete/"+t1.value;
	callApi("DELETE",url,"",getResponse);
	
}

function view(){
  var url="http://localhost:8080/hello/read";
  callApi("GET", url, " ", getResponseTable);
}
function getResponse(res) {
  l1.innerText = res;
}
function getResponseTable(res) {
      var data=JSON.parse(res);
  var table=`<table border="1">
        <tr> 
          <th> StudentId </th>
          <th> StudentName </th>
          <th> StudentContactNo </th>
          <th> AmountPaid </th>
          <th> PaymentStatys </th>
        </tr>`;
  for(var x in data){
    table+=`<tr>
          <td>` + data[x].id + `</td>
          <td>` + data[x].name + `</td>
          <td>` + data[x].number + `</td>
          <td>` + data[x].amount + `</td>
          <td>` + data[x].status + `</td>
      </tr>`;
    
  }
  table+=`</table>`;
  viewdata.innerHTML=table;
}

