
function GetClock(){
var d=new Date();
var nhour=d.getHours(),nmin=d.getMinutes(),ap;
if(nhour==0){ap=" AM";nhour=12;}
else if(nhour<12){ap=" AM";}
else if(nhour==12){ap=" PM";}
else if(nhour>12){ap=" PM";nhour-=12;}

if(nmin<=9) nmin="0"+nmin;

document.getElementById('box1').innerHTML="	<h3>Time</h3><div class='callout success'><h4>"+nhour+":"+nmin+ap+"</h4></div>";
}

window.onload=function(){
GetClock();
setInterval(GetClock,1000);
}
