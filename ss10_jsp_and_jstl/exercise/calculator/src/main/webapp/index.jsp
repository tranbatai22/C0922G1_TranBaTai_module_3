<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/29/2022
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h1>
    Simple Calculator
</h1>
<form action="/calculator" method="post" style="width: 450px">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>
                    <h3>First operand:</h3>
                </td>
                <td>
                    <input type="text" name="firstOperand">
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Operator:</h3>
                </td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>SecondOperand:</h3>
                </td>
                <td>
                    <input type="text" name="secondOperand">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Calculate</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
