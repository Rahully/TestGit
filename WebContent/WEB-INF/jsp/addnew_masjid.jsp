<!DOCTYPE html>
<html>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />

<head>
<meta charset="UTF-8">
<title>Add New Masjid | Clear Admin Template</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link rel="shortcut icon" href="img/favicon.ico" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<!-- global css -->
<link type="text/css" href="css/app.css" rel="stylesheet" />
<!-- end of global css -->
<!--page level css -->
<link href="vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	type="text/css" rel="stylesheet">
<link href="vendors/select2/css/select2.min.css" type="text/css"
	rel="stylesheet">
<link href="vendors/select2/css/select2-bootstrap.css" type="text/css"
	rel="stylesheet">
<link href="vendors/bootstrapvalidator/css/bootstrapValidator.min.css"
	type="text/css" rel="stylesheet">
<link href="vendors/datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="vendors/iCheck/css/all.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" href="css/custom_css/skins/skin-default.css"
	type="text/css" id="skin" />
<link href="css/custom_css/wizard.css" type="text/css" rel="stylesheet">
<!--end of page level css -->
<script>
	function isNumber(evt) {
		   var iKeyCode = (evt.which) ? evt.which : evt.keyCode
		   if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
		   return false;
		   return true;
		}
	</script>
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
				<h1>Add New Masjid</h1>

			</section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="panel">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="livicon" data-name="user-add" data-size="18"
										data-c="#fff" data-hc="#fff" data-loop="true"></i> Add New
									Masjid
								</h3>
								<span class="pull-right"> <i
									class="fa fa-fw ti-angle-up clickable"></i>
								</span>
							</div>
							<div class="panel-body">
								<!-- errors -->
								<!--main content-->
								<form action="AddMasjid" method="post" class="form-horizontal">
									<!-- CSRF Token -->
									<input type="hidden" name="_token" />
									<div id="pager_wizard">
										<ul>
											<li><a href="#tab1" data-toggle="tab">Masjid Profile</a>
											</li>

										</ul>

										<div class="tab-content">
											<div class="tab-pane" id="tab1">
												<h2 class="hidden">&nbsp;</h2>

												<div class="form-group">
													<label for="masjid_name" class="col-sm-3 control-label">Masjid
														Name * </label>
													<div class="col-sm-9">
														<input id="masjid_name" name="masjid" type="text"
															placeholder="Masjid Name " class="form-control required" />
													</div>
												</div>
												<div class="form-group">
													<label for="last_name" class="col-sm-3 control-label">Street
														* </label>
													<div class="col-sm-9">
														<input id="street" name="street" type="text"
															placeholder="Street Name" class="form-control required" />
													</div>
												</div>
												<div class="form-group">
													<label for="city" class="  col-sm-3 control-label">City
														*</label>
													<div class="col-sm-9">
														<input id="city" name="city" placeholder="City"
															type="text" class="form-control required email" />
													</div>
												</div>
												<div class="form-group">
													<label for="password" class="  col-sm-3 control-label">State
														*</label>
													<div class="col-sm-9">
														<input id="state" name="state" type="text"
															placeholder="State" class="form-control" required />
													</div>
												</div>

												<div class="form-group">
													<label for="zipcode" class="  col-sm-3 control-label">Zipcode
														*</label>
													<div class="col-sm-9">
														<input id="zipcode" name="zipcode" type="text"
															placeholder="zipcode" class="form-control"
															onkeypress="javascript:return isNumber(event)" maxlength="6" required />
													</div>
												</div>
											</div>



											<ul class="pager wizard">

												<li><input type="submit" name="save"
													class="btn btn-primary pull-rights" value="Create">
												</li>
											</ul>
								</form>
							</div>
						</div>
					</div>
				</div>

				<div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">User Register</h4>
							</div>
							<div class="modal-body">
								<p>Account Registered Successfully.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Ok</button>
							</div>
						</div>
					</div>
				</div>
	</div>
	</div>
	<!--row end-->
	<!--rightside bar -->
	<div class="background-overlay"></div>
	</section>
	</aside>
	</div>
	<!--wrapper ends-->
	<!-- global js -->
	<script src="js/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/g/bootstrap@3.3.7,bootstrap.switch@3.3.2,jquery.nicescroll@3.6.0"></script>
	<script src="js/app.js" type="text/javascript"></script>
	<!-- end of global js -->
	<!-- begining of page level js -->
	<script src="vendors/moment/js/moment.min.js"></script>
	<script src="vendors/jasny-bootstrap/js/jasny-bootstrap.js"
		type="text/javascript"></script>
	<script src="vendors/select2/js/select2.js" type="text/javascript"></script>
	<script src="vendors/bootstrapwizard/js/jquery.bootstrap.wizard.js"
		type="text/javascript"></script>
	<script src="vendors/bootstrapvalidator/js/bootstrapValidator.min.js"
		type="text/javascript"></script>
	<script src="vendors/datetimepicker/js/bootstrap-datetimepicker.min.js"
		type="text/javascript"></script>
	<script src="vendors/iCheck/js/icheck.js"></script>
	<script src="js/custom_js/adduser.js" type="text/javascript"></script>
	<!-- end of page level js -->
</body>

</html>
