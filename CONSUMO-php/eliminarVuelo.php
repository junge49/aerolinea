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
			$id=$_POST['cancelar'];
            print($id);
            $client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
            $parametros = array("id" => $id);
            $response = $client->__soapCall("EliminarVuelo", array($parametros));
		?>
		<h1>VUELO ELIMINADO</h1>
        <meta http-equiv="refresh" content="5;URL=http://localhost/tpis/php/consumo.php" />
			
		</div>
	</body>
</html>