<?php
	$name = $_POST["field1"];
	$fp = fopen("output.txt", "a");
	$savestring = $name . "\n";
	fwrite($fp, $savestring);
	fclose($fp);
	echo “<h1>You data has been saved in a text file!</h1>”;
?>