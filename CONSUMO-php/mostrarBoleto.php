

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
            if (empty($_POST['idBoleto'])) {
            ?>
            <form method = 'post' action="">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" name="idBoleto" id="idBoleto" placeholder="Ingresa el id de tu boleto" required>
                    </div>
                </div>
                <button type="submit" name="sub" class="btn btn-primary">BUSCAR BOLETO</button> 
            </form>
            <?php 
                }
            ?>  
            <?php  
            if (isset($_POST['idBoleto']) && !empty($_POST['idBoleto'])) {
                $client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
                $parametros = array("idBoleto" => $_POST['idBoleto']);
                $response = $client->__soapCall("ConsultarBoleto", array($parametros));
                $parametros2 = array("id" => $response->{'idVuelo'});
                $response2 = $client->__soapCall("ConsultarVuelo", array($parametros2));
            ?>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label >ID  BOLETO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="idBoleto" id="idBoleto" value="<?php echo $v=$response->{'idBoleto'};?>" >
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>ID VUELO:</label>
                        <input type="text" disabled="disabled" class="form-control" name="idVuelo" id="idVuelo" value="<?php echo $v=$response->{'idVuelo'};?>" >
                    </div>
                </div>
                 <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>NUMERO DE ASIENTO:</label>
                        <input type="text" class="form-control" name="noAsiento" id="noAsiento" value="<?php echo $response->{'noAsiento'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>NOMBRE DEL PASAJERO:</label>
                        <input type="text" class="form-control" name="nombrePasajero" id="nombrePasajero" value="<?php echo $response->{'nombrePasajero'};?>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>SALIDA:</label>
                        <input type="text" disabled="disabled" class="form-control" name="nombrePasajero" id="nombrePasajero" value="<?php echo $response2->{'salida'};?>">
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
                <form method = 'post' action="http://localhost/tpis/php/eliminarBoleto.php">
                    <div class="form-group col-md-6">
                        <button type="submit" name="cancelar" class="btn btn-primary" value="<?php echo $v=$response->{'idBoleto'};?>">CANCELAR BOLETO</button>
                    </div> 
                </form>
        <?php
        }
        ?>
    </body>
</html>