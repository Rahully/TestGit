<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>


<%@ page import="java.util.HashMap"%>
<%
	HashMap map = new HashMap();
	JSONArray object = JSONArray.fromObject(request.getAttribute("SlideListDetails"));
%>



<!DOCTYPE html>
<html>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />

<head>
<meta charset="UTF-8">
<title>Users List | Clear Admin Template</title>
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
<link rel="stylesheet" type="text/css"
	href="vendors/datatables/css/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" href="css/custom_css/skins/skin-default.css"
	type="text/css" id="skin" />
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
				<h1>SlideShow List</h1>
				<
			</section>
			<!-- Main content -->
			<section class="content p-l-r-15">
				<div class="row">
					<div class="col-md-12">
						<div class="panel">
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="ti-user"></i> SlideShow List <a href="AddNewSlide"
										class="btn btn-primary pull-right" style="margin-top: -8px;">
										Add New </a>
								</h4>

							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="table">
										<thead>
											<tr class="filters">
												<th>SlideShow Name</th>
												<th>File Name</th>
												<th>Image</th>
												<th>Start date</th>
												<th>End date</th>

												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<%
												int count = 1;
												for (int i = 0; i < object.size(); i++) {
													JSONObject SelectedObj = object.getJSONObject(i);
											%>

											<tr>
												<td><%=SelectedObj.getString("slideshow_name")%></td>
												<td><%=SelectedObj.getString("file_name")%></td>
												<td><img src="<%=SelectedObj.getString("image_path") %>" alt="image" height="80" width="150"></td>
												<td><%=SelectedObj.getString("startdate")%></td>
												<td><%=SelectedObj.getString("expirydate")%></td>
												<td><a href="EditSlide?id=<%=SelectedObj.getString("id")%>"><i
														class="fa fa-fw ti-pencil text-primary actions_icon"
														title="Edit User"></i></a><a href="DeleteSlide?id=<%=SelectedObj.getString("id")%>"><i
														class="fa fa-fw ti-close text-danger actions_icon"
														title="Delete User"></i> </a></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						
						<!-- /.modal-dialog -->
					</div>
				</div>
				<!-- row-->

				<div class="background-overlay"></div>
			</section>
		</aside>
	</div>
	<!-- global js -->
	<script src="js/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/g/bootstrap@3.3.7,bootstrap.switch@3.3.2,jquery.nicescroll@3.6.0"></script>
	<script src="js/app.js" type="text/javascript"></script>
	<!-- end of global js -->
	<!-- begining of page level js -->
	<script type="text/javascript"
		src="vendors/datatables/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="vendors/datatables/js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="js/custom_js/users_custom.js"></script>
	<!-- end of page level js -->
</body>

</html>
