<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>QCM</title>
	</head>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		 <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<body>
		<div class="row">
			<div class="col-md-6 col-md-push-3">
			<!-- boucle affichage des questions -->
			<!--  <p>Score:<span id="score">0</span></p>-->
			<c:forEach items="${Questions}" var="Question1" varStatus="index">
			 <!-- Bloc Question -->
			 <form method="get" action="ServletTraitementReponse">
			 <fieldset>
				<div id ="queststate" class="BlocQuestion">
					<div class="NumQuestion" >
						<legend><c:out value ="Numero de la question : ${Question1.numQuestion}"/></legend>
					
					</div>
					<div id ="" class="IntituleQuestion">
						<p><c:out value ="Intitulé : ${Question1.intituleQuestion}"/></p>
					</div>
						
				</div>
			
	
				<!-- Bloc Proposition -->
				<!-- Si le nb de proposition est superieur a 2 alors c'est des cases a cocher Sinon c'est des Btn radio -->
				
					<c:choose>
			    		<c:when test="${Question1.listProposition.size() > 2 }">
			    			<!-- Affichage de la liste des cases a cocher -->
			    			<c:forEach  items ="${Question1.listProposition}" var="propositionReponse"  varStatus ="compteur">
				    			
						    		<div class="fom-group">
						    		<label  for="case${index.index}${compteur.index}"><c:out value="${propositionReponse.libelle_Prop}"/></label>
						    		<input  name= "rep_case${index.index}" type="checkbox" id="case${index.index}${compteur.index}"  value="${compteur.index}">
						    		</div>
						  
					 		</c:forEach> 
			    		</c:when>
			    		<c:otherwise>
			    			<!-- Affichage de la liste des Btn radio -->
			    			<c:forEach  items ="${Question1.listProposition}" var="propositionReponse"  varStatus ="compteur">
				    			
				    				<input  name= "rep_radio${index.index}" type="radio" value="${compteur.index}"> <c:out value="${propositionReponse.libelle_Prop}"/><br>
						 		
					 		</c:forEach>  
			    		</c:otherwise>
					</c:choose>
				
				<input class="btn btn-primary" type="button"  value="valider" onclick="valider(${index.index})"  />
				<p id="validationResponse${index.index }"></p>
				</fieldset>
				<%-- NO AJAX <input type="submit"  value="valider" /> --%>
			</form>
			
			</c:forEach>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	var requete;

	
	
	function valider(index) {
	
		//recupérer tous les values des elements passés 
		var nodes = document.getElementsByName("rep_case"+index);
		console.log(nodes);
		var donnees=[];
		
		//balayer les elements et les rajouter au tableau des données		
		for (var i=0; i< nodes.length;i++) {
			
			if(nodes[i].checked && nodes[i].value.length < 2) {
				
				donnees.push(nodes[i].value);
			}
		}
		
		
		var url = "ServletTraitementReponse?valeur=" + escape(donnees)+"&index="+index;
		console.log(url);
		
		if (window.XMLHttpRequest) {
			
			requete = new XMLHttpRequest();
			
			} else if (window.ActiveXObject) {
			
			requete = new ActiveXObject("Microsoft.XMLHTTP");
		
		}
		
		requete.open("GET", url, true);
		
		requete.onreadystatechange = function majIHM() {
			
									var message = "";
									var score   = 0;
										 
										
										if (requete.readyState == 4) {
											
											if (requete.status == 200) {
												
												// exploitation des données de la réponse
												console.log(requete.responseXML.getElementsByTagName("message")[0]);
												console.log(requete.responseXML.getElementsByTagName("message")[1]);
												console.log(requete.responseXML.getElementsByTagName("score")[0]);
												
												var messageTag = requete.responseXML.getElementsByTagName("message")[0];
												
												message = messageTag.childNodes[0].nodeValue;
																								
												mdiv = document.getElementById("validationResponse"+index);
												console.log("response " + message);
												
												//la réponse est negative
												if (message == "false") {
												
													mdiv.innerHTML = " <strong>False!!</strong> La réponse n'est pas correcte.";
													mdiv.className = "alert alert-danger" ;
												
												// la réponse est positive
												} else if (message == "true") {
													
													mdiv.innerHTML = " <strong>Correct!!</strong> C'est la bonne réponse.";
													mdiv.className = "alert alert-success";
												
												//réponse dans les autres cas
												}else {
													mdiv.innerHTML = " <strong>Erreur!!</strong> Veuillez cocher au moins une case.";
													mdiv.className = "alert alert-info" ;
												}
												
												//récuperer score et l'afficher
												/*var scoreTag = requete.responseXML.getElementsByTagName("score")[0];
												score = scoreTag.childNodes[0].nodeValue;
												document.getElementById("score").innerHTML = score;*/
												
											
											}
										
										}
									
									};
		
		requete.send(null);
	
	}

	
	</script>
</html>