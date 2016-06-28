

function createTable(){

    var table = document.createElement('table');
     table.setAttribute('border', '1');

   var rows = document.getElementById("tRows").value;
   var cols = document.getElementById("tCols").value;

   
for (var i = 0; i < rows; i++){
    var tr = document.createElement('tr');   
    for(var j=0; j<cols; j++){
    var td = document.createElement('td');

    var text1 = document.createTextNode('Text');


    td.appendChild(text1);

    tr.appendChild(td);
    }

    table.appendChild(tr);
}
    
var theDiv = document.getElementById("table1");
theDiv.appendChild(table);

}