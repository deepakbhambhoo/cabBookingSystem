<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New User</h1>
       <form:form method="post" action="saveUser">  
      	<table >  
         <tr>  
          <td>User Name : </td> 
          <td><form:input path="userName"  /></td>
         </tr>  
         <tr>  
          <td>User Id:</td>  
          <td><form:input path="userId" /></td>
         </tr>  
          <tr>  
          <td>phone :</td>  
          <td><form:input path="phone" /></td>
         </tr>
          <tr>  
          <td>Location :</td>  
          <td><form:input path="location" /></td>
         </tr>
         
          <tr>  
          <td>Wallet :</td>  
          <td><form:input path="wallet" /></td>
         </tr>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
