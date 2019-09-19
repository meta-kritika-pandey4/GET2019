  
/*
 * It is a method to set the currency in the billing table
 * 
 *
 */
function cycleCurrency() {
       if( document.getElementById("USD").selected ) {
            document.getElementById("cp1").innerHTML = "00.07 USD";
            document.getElementById("cp2").innerHTML = "00.14 USD";
            document.getElementById("cp3").innerHTML = "07.00 USD";
       } else if( document.getElementById("YEN").selected) {
            document.getElementById("cp1").innerHTML = "7.5 YEN";
            document.getElementById("cp2").innerHTML = "15 YEN";
            document.getElementById("cp3").innerHTML = "753.9 YEN";
       } else {
            document.getElementById("cp1").innerHTML = "005.00 INR";
            document.getElementById("cp2").innerHTML = "100.00 INR";
            document.getElementById("cp3").innerHTML = "500.00 INR";
       }
}
function motorCycleCurrency() {
	if( document.getElementById("USD").selected ) {
		document.getElementById("mcp1").innerHTML = "00.14 USD";
        document.getElementById("mcp2").innerHTML = "02.80 USD";
        document.getElementById("mcp3").innerHTML = "14.00 USD";
    } else if( document.getElementById("YEN").selected ) {
    	document.getElementById("mcp1").innerHTML = "15 YEN";
    	document.getElementById("mcp2").innerHTML = "300 YEN";
    	document.getElementById("mcp3").innerHTML = "1500 YEN";
    } else {
            document.getElementById("mcp1").innerHTML = "0010.00 INR";
            document.getElementById("mcp2").innerHTML = "0200.00 INR";
            document.getElementById("mcp3").innerHTML = "1000.00 INR";
    }
} 
function fourwheelerCurrency(){
	if( document.getElementById("USD").selected ) {
		document.getElementById("fwp1").innerHTML = "00.28 USD";
        document.getElementById("fwp2").innerHTML = "07.00 USD";
        document.getElementById("fwp3").innerHTML = "49.00 USD";
    } else if( document.getElementById("YEN").selected ) {
    	document.getElementById("fwp1").innerHTML = "30 YEN";
    	document.getElementById("fwp2").innerHTML = "750 YEN";
    	document.getElementById("fwp3").innerHTML = "5250 YEN";
    } else {
    	document.getElementById("fwp1").innerHTML = "0020.00 INR";
    	document.getElementById("fwp2").innerHTML = "0500.00 INR";
    	document.getElementById("fwp3").innerHTML = "3500.00 INR";
    }
} 
