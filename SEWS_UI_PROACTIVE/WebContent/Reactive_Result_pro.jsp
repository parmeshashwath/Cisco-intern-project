<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  
  <style>
.container1 {
     position:relative;
     
    width:400px;
     top:324px;
     left:839px;
     
     
     
}
#uploadBtn{
position:relative;
    
     top:30px;
     left:403px;
     
}
#submitbutton{
position:relative;
    
     top:0px;
     left:403px;
     
}

  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  
  .heading{
  background-color:#505050;
  position:relative;
  top:0%;
  width:1700px;
  height:80px;
  
  
  }
 .container
 {
 position:relative;
 
  heigth:120px;
  left:3%;
  width:1000px;
  top:-90px;
  
 }
 .carousel-inner{
 position:relative;
  width:60%;
  left:20%;
  max-height: 700px !important;
}

 
  
  </style>
</head>
<body>


<div class ="heading">
<p align="center">
<font size="20" color="#FFFFFF">Symptom Based Early Warning System</font> </p>
</div>



<div class="container1">


<input id="uploadBtn" type="file" class="upload" multiple/>


<form role="form" action="servletresult_pro">
 
<input type="text" class="form-control" id="filepath" name="filenames">



   
    
    
   <button type="submit" id="submitbutton" class="btn btn-primary">Submit</button>
  
</form>
 
 </div>

<script>
  document.getElementById("uploadBtn").onchange = function () {
	    var x= document.getElementById("uploadBtn");
	    document.getElementById("filepath").value="";
	    for (var i = 0; i < x.files.length; i++) {
            
            var file = x.files[i];
            //if ('name' in file) {
            	document.getElementById("filepath").value +=  file.name+"&" ;
            //}
	    
  }
  }
  
	  
  
  </script>
  
  <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    <div class="item">
        <img src="images/Options-Analysis1.jpg" alt="self-Healing" width="460" height="100">
          
      </div>
      <div class="item active">
        <img src="images/img1_SH.jpg" alt="Proactive-Monitoring" width="460" height="100">
        
        
      </div>

      <div class="item">
        <img src="images/img2_TA.jpg" alt="Analysis" width="460" height="100">
        
       
        </div>
    
      

     
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>

</html>