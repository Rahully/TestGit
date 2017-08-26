
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>


<%@ page import="java.util.HashMap"%>
<%
	JSONArray object = JSONArray.fromObject(request.getAttribute("masjid_Details"));
%>






<!DOCTYPE html>
<html>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<head>
<meta charset="UTF-8">
<title>Form Elements | Clear Admin Template</title>
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
<link href="vendors/iCheck/css/all.css" rel="stylesheet" />
<link href="vendors/bootstrap-fileinput/css/fileinput.min.css"
	media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" href="css/custom_css/skins/skin-default.css"
	type="text/css" id="skin" />
<link rel="stylesheet" type="text/css" href="css/formelements.css">
<!--end of page level css-->

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
				<h1>Add New Slideshow</h1>

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
									Slide
								</h3>
								<span class="pull-right"> <i
									class="fa fa-fw ti-angle-up clickable"></i>
								</span>
							</div>
							<div class="panel-body">
								<!-- errors -->
								<!--main content-->
								<form action="AddSlideShow" id="adduser_form" method="post"
									class="form-horizontal">


									<div class="tab-content">
										<div class="form-group">
											<label for="slideshow_name" class="col-sm-3 control-label">Masjid
												Name* </label>
											<div class="col-sm-6">
												<div class="col-sm-6">
													<select class="form-control" name="masjid">
														<option value="">Select Masjid</option>
														<%
															for (int i = 0; i < object.size(); i++) {
																JSONObject SelectedObj = object.getJSONObject(i);
														%>
														<option value="<%=SelectedObj.getString("id")%>"><%=SelectedObj.getString("masjid_name")%></option>


														<option value=""></option>

														<%
															}
														%>

													</select>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="slideshow_name" class="col-sm-3 control-label">Slideshow
												Name* </label>
											<div class="col-sm-6">
												<div class="col-sm-6">
													<input id="slideshow_name" name="slideshow_name"
														type="text" placeholder="Slideshow Name"
														class="form-control required" />
												</div>
											</div>
										</div>



										<!--  		<div class="form-group">
                            
                            
                                                <label for="last_name" class="col-sm-3 control-label">Slides
                                                </label>
                                                <div class="col-sm-5">
                                                    <select class="form-control" name="" id="slide">
                                                    		<option value="">Select Slide</option>
                                                    		<option value="1"> Slide1 </option>
                                                    </select>
                                                    <input type="hidden" id="tabindex" value="">
                                                </div>
                                                <div class="col-sm-1">
                                                    <a href="javascript: myFunction()" class="btn btn-primary"><i class="fa fa-plus"></i></a>
                                                </div>
                                            </div>  
                                            <div class="form-group">
                                                <label for="start_date" class="  col-sm-3 control-label">&nbsp;</label>
                                                <div class="col-sm-6">
                                                    <table class="table table-bordered table-striped" id="myTable">
								                        <thead>
								                          <tr>
								                            <th>Slide Name</th>
								                            <th>Action</th>
								                          </tr>
								                        </thead>
								                        <tbody>
								                        
								                        </tbody>
								                     </table>
                                                </div>
                                            </div> -->

										<ul class="pager wizard">

											<li><input type="submit" name="save"
												class="btn btn-primary pull-rights" value="Create">
											</li>
										</ul>
									</div>

								</form>

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
					</div>
				</div>
				<!--row end-->

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

	<!-- page level js -->

	<script src="vendors/bootstrap-fileinput/js/fileinput.min.js"
		type="text/javascript"></script>
	<script src="js/custom_js/form_elements.js"></script>
	<script>
		function myFunction() {
			var val = document.getElementById('slide').value;
			if (val == '0' || val == '') {
				alert('Please select Slide');
			} else {
				var slide_name = document.getElementById('slide').value;
				var index = parseFloat(document.getElementById('tabindex').value);
				var vals = "";
				if (index == 'NaN') {
					var index = 2;
				}
				var table = document.getElementById("myTable");
				var row = table.insertRow(1);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				cell1.innerHTML = '<input type="text" class="form-control" name="slide_name[]" id="" value="'+slide_name+'" />';
				cell2.innerHTML = '<a href="javascript: deleteRow('
						+ index
						+ ')" class="btn btn-primary"><i class="fa fa-minus"></i> Remove</a>';
				document.getElementById('slide').value = '';
				document.getElementById('tabindex').value = index + 1;
			}

		}
		function deleteRow(id) {
			document.getElementById("myTable").deleteRow(id);
		}
	</script>
	<!-- end of page level js -->
</body>

</html>
