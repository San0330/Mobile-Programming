<?php

// Start server by running "php -S 0.0.0.0:8000" in terminal or command line

$server = "localhost";
$username="santosh";
$password ="password";
$database = "mobileprog";

// first create database from command line
// then create table from command line
// insert data into table from command line
$conn = new mysqli($server, $username, $password, $database);

if($conn->connect_error){
    die("Connection failed");
}

// code to retrieve data from mysql

$query = "SELECT * FROM students";
$result = $conn->query($query);

$json = array();
if($result->num_rows > 0){
    while($row = $result->fetch_array()){
        $json['data'][] = array("sid" => $row["sid"], "name" => $row["name"]);        
    }
}

echo json_encode($json);
$conn->close();
?>