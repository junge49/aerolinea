<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>INICIO</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body background="avion-comercial-516e04fe6ed56.jpg">
        <div class="row" >
            <div class="col-12 col-md-8"><br><h1 class="text-info">AEROLINEA</h1></br></div>
            <div class="col-6 col-md-4">
                <form method="post" action="http://localhost/tpis/php/mostrarBoleto.php">
                    <br>
                    <button type="submit" class="btn btn-outline-dark" name="buscarBoleto">BUSCAR BOLETO</button>
                </br>
                </form>
            </div>
        </div>
        <div class="form-group col-md-10">
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                      <th scope="col">SALIDA</th>
                      <th scope="col">DESTINO</th>
                      <th scope="col">FECHA</th>
                      <th scope="col">HORA</th>
                      <th scope="col">COSTO</th>
                      <th scope="col"></th>
                    </tr>
                </thead>
            <?php  
                $client = new SoapClient('http://localhost:8080/ws/aerolinea.wsdl');
                $response = $client->__soapCall("BuscarVuelos", array());
                foreach ($response->{'Vuelos'} as $key => $value) {
            ?>
            <tbody>
                <tr>
                    <td>"<?php echo $value->{'salida'};?>"</td>
                    <td>"<?php echo $value->{'destino'};?>"</td>
                    <td>"<?php echo $value->{'fecha'};?>"</td>
                    <td>"<?php echo $value->{'hora'};?>"</td>
                    <td>"<?php echo $value->{'costo'};?>"</td>
                    <td>
                        <form method = 'post' action="http://localhost/tpis/php/comprarBoleto.php">
                            <button type="submit" name="sub" class="btn btn-primary" value="<?php echo $value->{'id'};?>">COMPRAR BOLETO</button>
                        </form>
                    </td>
                </tr>
            <?php        
                }
            ?>
                </tbody>
            </table>
        </div>
    </body>
</html>