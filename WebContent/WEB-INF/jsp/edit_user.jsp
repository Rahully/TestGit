<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>


<%@ page import="java.util.HashMap"%>
<%
	HashMap map = new HashMap();
	JSONObject object = JSONObject.fromObject(request.getAttribute("userDetails"));
	
%>






<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>" />
    <meta charset="UTF-8">
    <title>Edit User | Clear Admin Template </title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="img/favicon.ico"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- global css -->
    <link type="text/css" href="css/app.css" rel="stylesheet"/>
    <!-- end of global css -->
    <!--page level css -->
    <link href="vendors/jasny-bootstrap/css/jasny-bootstrap.css" type="text/css" rel="stylesheet">
    <link href="vendors/select2/css/select2.min.css" type="text/css" rel="stylesheet">
    <link href="vendors/select2/css/select2-bootstrap.css" type="text/css" rel="stylesheet">
    <link href="vendors/bootstrapvalidator/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet">
    <link href="vendors/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="vendors/iCheck/css/all.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css">
    <link rel="stylesheet" href="css/custom_css/skins/skin-default.css" type="text/css" id="skin"/>
    <link href="css/custom_css/wizard.css" type="text/css" rel="stylesheet">
    <!--end of page level css -->

</head>

<body class="skin-default">
<div class="preloader">
    <div class="loader_img">
        <img src="img/loader.gif" alt="loading..." height="64" width="64">
    </div>
</div>

<!-- header logo: style can be found in header-->
<%@ include file="header.jsp"%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
      <%@ include file="sidemenu.jsp"%>
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Edit User
            </h1>
            
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <i class="livicon" data-name="user-add" data-size="18" data-c="#fff" data-hc="#fff"
                                   data-loop="true"></i> Add New User
                            </h3>
                            <span class="pull-right">
                                    <i class="fa fa-fw ti-angle-up clickable"></i>
                                </span>
                        </div>
                        <div class="panel-body">
                            <!-- errors -->
                            <!--main content-->
                            <form action="EditUser?uid=<%= object.getString("user_id") %>" method="post"  class="form-horizontal">
                            		<div class="form-group">
                                                <label for="masjid_name" class="col-sm-3 control-label">Masjid Name*
                                                </label>
                                                <div class="col-sm-6">
										<input type="text" class="form-control" name="masjid_name" value="<%=  object.getString("masjid_name") %>">
									</div>
                                            
                                              			</div>
								<div class="form-group">
									<label for="name" class="col-sm-3 control-label">Name * </label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="name" value="<%=  object.getString("Name") %>">
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="masjid_name" class="col-sm-3 control-label">Email * </label>
									<div class="col-sm-6">
										<input type="email" class="form-control" name="email" value="<%=  object.getString("email_id") %>">
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="contact_number" class="col-sm-3 control-label">Contact Number * </label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="contact_number" value="<%=  object.getString("contact_number") %>">
									</div>
								</div>
								
								<div class="form-group">
									<label for="masjid_name" class="col-sm-3 control-label">Password * </label>
									<div class="col-sm-6">
										<input type="password" class="form-control" name="password" value="<%=  object.getString("password") %>">
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="masjid_name" class="col-sm-3 control-label">Confirm Password* </label>
									<div class="col-sm-6">
										<input type="password" class="form-control" name="cnf_password" value="<%=  object.getString("password") %>">
									</div>
								</div>
								<div class="form-group">
									<label for="masjid_name" class="col-sm-3 control-label">User Group * </label>
									<div class="col-sm-6">
										<select id="user_group" name="user_group" class="form-control">
											<option value=""><%=  object.getString("isSuperAdmin") %></option>
											<option value="superadmin">Superadmin</option>
											<option value="Admin">Admin</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="masjid_name" class="col-sm-3 control-label">Status * </label>
									<div class="col-sm-6">
										<select id="status" name="status" class="form-control">
											<option value=""><%=  object.getString("isActive") %></option>
											<option value="active">Active</option>
											<option value="inactive">Inactive</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="remark" class="col-sm-3 control-label">Remark * </label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="remark" value="<%=  object.getString("Remark") %>">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-6">
										<button type="submit" class="btn btn-primary pull-right"><i class="fa fa-save"></i> UPDATE</button>
										
									</div>
								</div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--row end-->

            <div class="background-overlay"></div>
        </section>
    </aside>
</div>
<!--wrapper ends-->
<!-- global js -->
<script src="js/jquery.min.js"></script> <script src="https://cdn.jsdelivr.net/g/bootstrap@3.3.7,bootstrap.switch@3.3.2,jquery.nicescroll@3.6.0"></script> <script src="js/app.js" type="text/javascript"></script><!-- end of global js -->
<!-- begining of page level js -->
<script src="vendors/moment/js/moment.min.js"></script>
<script src="vendors/jasny-bootstrap/js/jasny-bootstrap.js" type="text/javascript"></script>
<script src="vendors/select2/js/select2.js" type="text/javascript"></script>
<script src="vendors/bootstrapwizard/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
<script src="vendors/bootstrapvalidator/js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="vendors/datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="vendors/iCheck/js/icheck.js" type="text/javascript"></script>
<script src="js/custom_js/adduser.js" type="text/javascript"></script>
<!-- end of page level js -->
</body>

</html>
