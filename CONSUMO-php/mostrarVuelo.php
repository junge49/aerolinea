<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Mostrar Boleto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body background="avion-comercial-516e04fe6ed56.jpg">
        <div class="form-group col-md-10">
            <br><h1 class="text-info">BUSCAR BOLETO</h1></br>
            <?php  
            if (empty($_POST['id'])) {
            ?>
            <form method = 'post' action="">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" name="id" id="id" placeholder="Ingresa el id del vuelo" required>
                    </div>
                </div>
                <button type="submit" name="sub" class="btn btn-primary">BUSCAR VUELO</button> 
            </form>
            <?php 
                }
            ?>  
            <?php  
            if (isset($_POST['id']) && !empty($_POST['id'])) {
                $client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
                $parametros2 = array("id" => $_POST['id']);
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
                        <input type="text" disabled="disabled" class="form-control" name="salida" id="salida" value="<?php echo $v=$response2->{'salida'};?>" >
                    </div>
                </div>
                 <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>DESTINO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="destino" id="destino" value="<?php echo $response2->{'destino'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>FECHA:</label>
                        <input type="text" disabled="disabled" class="form-control" name="fecha" id="fecha" value="<?php echo $response2->{'fecha'};?>">
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