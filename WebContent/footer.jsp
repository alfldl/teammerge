<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<footer style="clear: right;">

 	 <ul style="list-style-type:none;">
  	 	 <li>Copyright© 2020 j20200303 TEAM3 ALL RIGHTS RESERVED</li>
 	 </ul>
  
	</footer> <!-- footer -->

	</div> <!-- wrap -->
	
	<script>
				window.onscroll = function() {myFunction()};

				var navbar = document.getElementById("navbar");
				var sticky = navbar.offsetTop;

				function myFunction() {
				  if (window.pageYOffset >= sticky) {
				    navbar.classList.add("sticky");
				  } else {
				    navbar.classList.remove("sticky");
				  }
				}
						</script>
						
</body>
</html>