<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Cab</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Cab Name : </td> 
          <td><form:input path="cabName"  /></td>
         </tr>  
         <tr>  
          <td>cabNumber:</td>  
          <td><form:input path="cabNumber" /></td>
         </tr> 
         <tr>  
          <td>driverName :</td>  
          <td><form:input path="driverName" /></td>
         </tr> 
          <tr>  
          <td>phone :</td>  
          <td><form:input path="phone" /></td>
         </tr>
          <tr>  
          <td>city :</td>  
          <td><form:input path="city" /></td>
         </tr>
         
          <tr>  
          <td>available :</td>  
          <td><form:input path="available" /></td>
         </tr>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
