<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Agregar vuelo</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	</head>
	<body background="avion-comercial-516e04fe6ed56.jpg">
		<br><h1 class="text-info">AGREGAR VUELO</h1></br>
		<div class="form-group col-md-10">
			<?php
				if (empty($_POST['salida'])) {
			?>
			<form method = 'post' action="">
	            <div class="form-row">
					<div class="form-group col-md-6">
		                <input type="text" class="form-control" name="salida" id="salida" placeholder="Escribe el lugar de salida" required>
	            	</div>
	            </div>
	             <div class="form-row">
		            <div class="form-group col-md-6">
		                <input type="text" class="form-control" name="destino" id="destino" placeholder="Escribe el destino" required>
		            </div>
		        </div>
		        <div class="form-row">
		            <div class="form-group col-md-6">  
		                <input name="fecha" class="form-control" id="fecha" type="date" required>
		            </div>
		        </div>
		        <div class="form-row">
		            <div class="form-group col-md-6">
		                <input type="time" class="form-control" name="hora" id="hora" step='1' min="00:00:00" max="23:59:59" required>
		            </div>
		        </div>
		        <div class="form-row">
		            <div class="form-group col-md-6">
		                <input type="text" class="form-control" name="costo" id="costo" placeholder="Escribe el costo del boleto" required>
		            </div>
		        </div>
		        <div class="form-row">
		            <div class="form-group col-md-6">
		                <input type="text" class="form-control" name="noAsientos" id="noAsientos" placeholder="Escribe el numero de asientos" required>
		            </div>
		        </div>
	            <button type="submit" name="sub" class="btn btn-primary">AGREGAR VUELO</button> 
			</form>
			<div class="form-group col-md-10">
		<form method = 'post' action="http://localhost/tpis/php/mostrarVuelo.php">
            <div class="form-group col-md-6">
                <button type="submit" name="cancelar" class="btn btn-primary">BUSCAR VUELO</button>
    	        </div> 
        </form>
		</div>
		<?php
		} 
			if (isset($_POST['salida']) && !empty($_POST['salida'])) {
				$client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
				$parametros = array("salida" => $_POST['salida'],
									"destino" => $_POST['destino'],
									"fecha" => $_POST['fecha'],
									"hora" => $_POST['hora'],
									"costo" => $_POST['costo'],
									"noAsientos" => $_POST['noAsientos']);
				$response = $client->__soapCall("AgregarVuelo", array($parametros));
				$parametros2 = array("id" => $response->{'id'});
				$response2 = $client->__soapCall("ConsultarVuelo", array($parametros2));
		?>
		<div class="form-row">
                    <div class="form-group col-md-6">
                        <label >ID  VUELO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="id" id="id" value="<?php echo $v=$response2->{'id'};?>" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>SALIDA:</label>
                        <input type="text" disabled="disabled" class="form-control" name="salida" id="salida" value="<?php echo $v=$response->{'salida'};?>" >
                    </div>
                </div>
                 <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>DESTINO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="destino" id="destino" value="<?php echo $response->{'destino'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>FECHA:</label>
                        <input type="text" disabled="disabled" class="form-control" name="fecha" id="fecha" value="<?php echo $response->{'fecha'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>HORA:</label>
                        <input type="text" disabled="disabled" class="form-control" name="hora" id="hora" value="<?php echo $response2->{'hora'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>COSTO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="costo" id="costo" value="<?php echo $response2->{'costo'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>NUMERO DE ASIENTOS:</label>
                        <input type="text" disabled="disabled" class="form-control" name="noAsientos" id="noAsientos" value="<?php echo $response2->{'noAsientos'};?>">
                    </div>
                </div>
                <form method = 'post' action="http://localhost/tpis/php/eliminarVuelo.php">
                    <div class="form-group col-md-6">
                        <button type="submit" name="cancelar" class="btn btn-primary" value="<?php echo $v=$response2->{'id'};?>">ELIMINAR VUELO</button>
                    </div> 
                </form>
                
		<?php
			}
		?>
		
		</div>
	</body>
</html>