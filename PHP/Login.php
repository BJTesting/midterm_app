<?php
    $con = mysqli_connect("localhost", "root", "root", "app");
    
    $username = $_POST["username"];
	$email = $_POST["email"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE (username = ? OR email = ?) AND password = ?");
    mysqli_stmt_bind_param($statement, "sss", $username, $email, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $username, $email, $password, $profile);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["email"] = $email;
        $response["password"] = $password;
    }
    
    echo json_encode($response);
?>