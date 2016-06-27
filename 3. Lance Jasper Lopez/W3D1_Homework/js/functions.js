

function isEmail(){
var emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var holder = document.getElementById("email1Result");
var email = document.getElementById("email1Input").value;
holder.innerHTML = ""
var check = emailPattern.test(email);
if(check){
	holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
 }
 else{
 	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
 }

}

function isEmail2(){

var holder = document.getElementById("email2Result");
var email = document.getElementById("email2Input").value;
var emailCheck1 = email.indexOf("@");
var emailCheck2 = email.lastIndexOf(".");
holder.innerHTML = ""

if(emailCheck1 != -1){
	if(emailCheck2 != -1){
	holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
	}
	else{
		holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
	}
 }
 else{
 	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
 }

}


function isDate(){
var datePattern = /^\d{2}[./-]\d{2}[./-]\d{4}$/;
var holder = document.getElementById("date1Result");
var date = document.getElementById("date1Input").value;
holder.innerHTML = ""
var check =  datePattern.test(date);

if(check){
	holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
 }
 else{
 	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
 }

}

function isDate2(){
var datePattern = /^\d{2}[./-]\d{2}[./-]\d{4}$/;
var holder = document.getElementById("date2Result");
var date = document.getElementById("date2Input").value;
holder.innerHTML = ""
var dateArr = date.split('/');
 if (dateArr.length == 3) {
         if (dateArr[0].length == 2 && dateArr[1].length == 2 && dateArr[2].length == 4) {
         	var dateCheck = Date.parse(date);
         	if(isNaN(dateCheck)){
         		holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
         	}
         	else{
         		holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
         		
         	}

         }
         else{
         	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
         }

     }
     else{
     	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
     }



}



function isEmpty(){
var emptyPattern = /^$/;
var holder = document.getElementById("text1Result");
var text = document.getElementById("text1Input").value;
holder.innerHTML = ""
var check =  emptyPattern.test(text);

if(check){
	holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
 }
 else{
 	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
 }


}

function isEmpty2(){

var holder = document.getElementById("text2Result");
var text = document.getElementById("text2Input").value;
holder.innerHTML = ""


if(!text.length){
	holder.innerHTML = "<div class=\"callout success\"> <h5>True</h5></div>";
 }
 else{
 	holder.innerHTML = "<div class=\"callout alert\"> <h5>False</h5></div>";
 }


}

function replaceWithHyphen(){
var patternToReplace = /\*e/gi;
var newText = '';
var holder = document.getElementById("replace1Result");
var text = document.getElementById("replace1Input").value;
newText = text;
newText = newText.replace(patternToReplace, '-');

holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";
}


function replaceWithHyphen2(){
var newText = '';
var holder = document.getElementById("replace2Result");
var text = document.getElementById("replace2Input").value;
newText =  text.split('e').join('E');
newText = newText.split('*E').join('-');

holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";
}

function removeTrailingSucceedingSpace(){
var spacePattern = /^\s+|\s+$/g;
var newText = '';
var holder = document.getElementById("trim1Result");
var text = document.getElementById("trim1Input").value;
newText = text;
newText = newText.replace(spacePattern, '');

holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";
}

function removeTrailingSucceedingSpace2(){

var newText = '';
var holder = document.getElementById("trim2Result");
var text = document.getElementById("trim2Input").value;
newText = text.trim();


holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";
}

function interchange(){
var pattern1 = /^.+--/i;
var pattern2 = /--.+$/i;
var newText = '';
var holder = document.getElementById("inter1Result");
var text = document.getElementById("inter1Input").value;
var test1 = text.match(pattern1);
var test2 = text.match(pattern2);
test1[0] = test1[0].replace("--", '');
test2[0] = test2[0].replace("--", '');

newText = test2[0] + "--" + test1[0];
holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";



}
function interchange2(){

var newText = '';
var holder = document.getElementById("inter2Result");
var text = document.getElementById("inter2Input").value;

var splitText = text.split("--");

newText = splitText[1] + "--" + splitText[0];
holder.innerHTML = "<div class=\"callout\"> <h5>" +newText + "</h5></div>";



}
