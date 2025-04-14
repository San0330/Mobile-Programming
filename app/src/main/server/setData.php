<?php

// Start server by running "php -S 0.0.0.0:8000" in terminal or command line

$server = "localhost";
$username="santosh";
$password ="password";
$database = "mobileprog";

// first create database from command line
// then create table from command line
$conn = new mysqli($server, $username, $password, $database);

if($conn->connect_error){
    die("Connection failed");
}

// code to insert data into database table

// getting POST data
$sid = $_POST["sid"];
$name = $_POST["name"];

$query = "INSERT INTO students(sid,name) VALUES('".$sid."','".$name."')";
$result = $conn->query($query);

if($result){
    echo "Data inserted successfully";
}else{
    echo "Failed to insert data";
}

$conn->close();
?>