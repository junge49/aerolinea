<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Comprar Boleto</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	</head>
	<body background="avion-comercial-516e04fe6ed56.jpg">
        <div class="form-group col-md-10">
		<?php
			$idBoleto=$_POST['cancelar'];
            print($idBoleto);
            $client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
            $parametros = array("idBoleto" => $idBoleto);
            $response = $client->__soapCall("EliminarBoleto", array($parametros));
		?>
		<h1>BOLETO CANCELADO</h1>
        <meta http-equiv="refresh" content="5;URL=http://localhost/tpis/php/index.php" />
			
		</div>
	</body>
</html>