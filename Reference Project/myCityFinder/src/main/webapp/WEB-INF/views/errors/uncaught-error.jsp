<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/errors/uncaught-error.p.vm.jsp
--%>
<html>
	<head>
		<title>Oops! An exception!</title>
	</head>
	<body>
		<h3>Oops! An exception!</h3>
		<pre>
			${exception}
		</pre>

		<p>
			This page is displayed when an exception is caught by the Servlet container.<br/>
		</p>
	</body>
</html>