<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>


<%@ page import="java.util.HashMap"%>
<%
	HashMap map = new HashMap();
	JSONArray object = JSONArray.fromObject(request.getAttribute("appVersionDetails"));
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
				<h1>App Version List</h1>
				
			</section>
			<!-- Main content -->
			<section class="content p-l-r-15">
				<div class="row">
					<div class="col-md-12">
						<div class="panel">
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="ti-user"></i> App Version List <a
										href="AddAppVersion"
										class="btn btn-primary pull-right" style="margin-top: -8px;" >
									Add New </a>
								</h4>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="table">
										<thead>
											<tr class="filters">
												<th>ID</th>
												<th>Version</th>
												<th>Version Date</th>
												<th>Description</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>



											<%
											out.println(object.size());
												for (int i = 0; i < object.size(); i++) {
													JSONObject SelectedObj = object.getJSONObject(i);
											%>
											<tr>
												<td>1</td>
												<td><%=SelectedObj.getString("version")%></td>
												<td><%=SelectedObj.getString("version_date")%></td>
												<td><%=SelectedObj.getString("description")%></td>
												<td><a href="EditAppVersion?aid=<%=SelectedObj.getString("app_ver_id")%>"> <i
														class="fa fa-fw ti-pencil text-primary actions_icon "
														title="Edit App Version"></i>
												</a> <a href="DeleteAppVersion?aid=<%=SelectedObj.getString("app_ver_id")%>">
														<i class="fa fa-fw ti-close text-danger actions_icon"
														title="Delete User"></i>
												</a></td>
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
				<!--rightside bar -->
				<div id="right">
					<div id="right-slim">
						<div class="rightsidebar-right">
							<div class="rightsidebar-right-content">
								<div class="panel-tabs">
									<ul class="nav nav-tabs nav-float" role="tablist">
										<li class="active text-center"><a href="#r_tab1"
											role="tab" data-toggle="tab"><i
												class="fa fa-fw ti-comments"></i></a></li>
										<li class="text-center"><a href="#r_tab2" role="tab"
											data-toggle="tab"><i class="fa fa-fw ti-bell"></i></a></li>
										<li class="text-center"><a href="#r_tab3" role="tab"
											data-toggle="tab"><i class="fa fa-fw ti-settings"></i></a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="r_tab1">
										<div id="slim_t1">
											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="menu-icon  fa fa-fw ti-user"></i> Contacts
											</h5>
											<ul class="list-unstyled margin-none">
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar6.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-primary"></i> Annette
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar.jpg" class="img-circle pull-right"
														alt="avatar-image"> <i
														class="fa fa-circle text-xs text-primary"></i> Jordan
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar2.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-primary"></i> Stewart
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar3.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-warning"></i> Alfred
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar4.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-danger"></i> Eileen
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar5.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-muted"></i> Robert
												</a></li>
												<li class="rightsidebar-contact-wrapper"><a
													class="rightsidebar-contact" href="#"> <img
														src="img/authors/avatar7.jpg"
														class="img-circle pull-right" alt="avatar-image"> <i
														class="fa fa-circle text-xs text-muted"></i> Cassandra
												</a></li>
											</ul>

											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="fa fa-fw ti-export"></i> Recent Updates
											</h5>
											<div>
												<ul class="list-unstyled">
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-comments-smiley fa-fw text-primary"></i>
															New Comment
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-twitter-alt fa-fw text-success"></i> 3
															New Followers
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-email fa-fw text-info"></i> Message Sent
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-write fa-fw text-warning"></i> New Task
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-export fa-fw text-danger"></i> Server
															Rebooted
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-info-alt fa-fw text-primary"></i> Server
															Not Responding
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-shopping-cart fa-fw text-success"></i>
															New Order Placed
													</a></li>
													<li class="rightsidebar-notification"><a href="#">
															<i class="fa ti-money fa-fw text-info"></i> Payment
															Received
													</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="r_tab2">
										<div id="slim_t2">
											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="fa fa-fw ti-bell"></i> Notifications
											</h5>
											<ul class="list-unstyled m-t-15 notifications">
												<li><a href="#" class="message icon-not striped-col">
														<img class="message-image img-circle"
														src="img/authors/avatar3.jpg" alt="avatar-image">

														<div class="message-body">
															<strong>John Doe</strong> <br> 5 members joined
															today <br> <small class="noti-date">Just now</small>
														</div>

												</a></li>
												<li><a href="#" class="message icon-not"> <img
														class="message-image img-circle"
														src="img/authors/avatar.jpg" alt="avatar-image">
														<div class="message-body">
															<strong>Tony</strong> <br> likes a photo of you <br>
															<small class="noti-date">5 min</small>
														</div>
												</a></li>
												<li><a href="#" class="message icon-not striped-col">
														<img class="message-image img-circle"
														src="img/authors/avatar6.jpg" alt="avatar-image">

														<div class="message-body">
															<strong>John</strong> <br> Dont forgot to call... <br>
															<small class="noti-date">11 min</small>
														</div>
												</a></li>
												<li><a href="#" class="message icon-not"> <img
														class="message-image img-circle"
														src="img/authors/avatar1.jpg" alt="avatar-image">
														<div class="message-body">
															<strong>Jenny Kerry</strong> <br> Done with it... <br>
															<small class="noti-date">1 Hour</small>
														</div>
												</a></li>
												<li><a href="#" class="message icon-not striped-col">
														<img class="message-image img-circle"
														src="img/authors/avatar7.jpg" alt="avatar-image">

														<div class="message-body">
															<strong>Ernest Kerry</strong> <br> 2 members joined
															today <br> <small class="noti-date">3 Days</small>
														</div>
												</a></li>
												<li class="text-right noti-footer"><a href="#">View
														All Notifications <i class="ti-arrow-right"></i>
												</a></li>
											</ul>
											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="fa fa-fw ti-check-box"></i> Tasks
											</h5>
											<ul class="list-unstyled m-t-15">
												<li>
													<div>
														<p>
															<span>Button Design</span> <small
																class="pull-right text-muted">40%</small>
														</p>
														<div class="progress progress-xs progress-striped active">
															<div class="progress-bar progress-bar-success"
																role="progressbar" aria-valuenow="40" aria-valuemin="0"
																aria-valuemax="100" style="width: 40%">
																<span class="sr-only">40% Complete (success)</span>
															</div>
														</div>
													</div>
												</li>
												<li>
													<div>
														<p>
															<span>Theme Creation</span> <small
																class="pull-right text-muted">20%</small>
														</p>
														<div class="progress progress-xs progress-striped active">
															<div class="progress-bar progress-bar-info"
																role="progressbar" aria-valuenow="20" aria-valuemin="0"
																aria-valuemax="100" style="width: 20%">
																<span class="sr-only">20% Complete</span>
															</div>
														</div>
													</div>
												</li>
												<li>
													<div>
														<p>
															<span>XYZ Task To Do</span> <small
																class="pull-right text-muted">60%</small>
														</p>
														<div class="progress progress-xs progress-striped active">
															<div class="progress-bar progress-bar-warning"
																role="progressbar" aria-valuenow="60" aria-valuemin="0"
																aria-valuemax="100" style="width: 60%">
																<span class="sr-only">60% Complete (warning)</span>
															</div>
														</div>
													</div>
												</li>
												<li>
													<div>
														<p>
															<span>Transitions Creation</span> <small
																class="pull-right text-muted">80%</small>
														</p>
														<div class="progress progress-xs progress-striped active">
															<div class="progress-bar progress-bar-danger"
																role="progressbar" aria-valuenow="80" aria-valuemin="0"
																aria-valuemax="100" style="width: 80%">
																<span class="sr-only">80% Complete (danger)</span>
															</div>
														</div>
													</div>
												</li>
												<li class="text-right"><a href="#">View All Tasks <i
														class="ti-arrow-right"></i></a></li>
											</ul>

										</div>
									</div>
									<div class="tab-pane fade" id="r_tab3">
										<div id="slim_t3">
											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="fa fa-fw ti-layers"></i> Skins
											</h5>
											<ul>
												<li class="setting-color"><label class="active-color">
														<input name='skins' type='radio'
														onchange='change_skin("skin-default");' checked='checked' />
														<span class='split'> <span
															class='color bg-default-clear'></span> <span
															class='color bg-default-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label> <label> <input name='skins' type='radio'
														onchange='change_skin("skin-mint");' /> <span
														class='split'> <span class='color bg-mint'></span>
															<span class='color bg-mint-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label> <label> <input name='skins' type='radio'
														onchange='change_skin("skin-grape");' /> <span
														class='split'> <span class='color bg-grape'></span>
															<span class='color bg-grape-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label></li>
												<li class="setting-color"><label> <input
														name='skins' type='radio'
														onchange='change_skin("skin-lavender");' /> <span
														class='split'> <span class='color bg-lavender'></span>
															<span class='color bg-lavender-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label> <label> <input name='skins' type='radio'
														onchange='change_skin("skin-pink");' /> <span
														class='split'> <span class='color bg-pink'></span>
															<span class='color bg-pink-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label> <label> <input name='skins' type='radio'
														onchange='change_skin("skin-sunflower");' /> <span
														class='split'> <span class='color bg-sunflower'></span>
															<span class='color bg-sunflower-light'></span>
													</span> <span class='color l-m-bg'></span>
												</label></li>
											</ul>
											<h5
												class="rightsidebar-right-heading text-uppercase gen-sett-m-t text-xs">
												<i class="fa fa-fw ti-settings"></i> General
											</h5>
											<ul class="list-unstyled settings-list m-t-10">
												<li><label for="status">Available</label> <span
													class="pull-right"> <input type="checkbox"
														id="status" name="my-checkbox" checked>
												</span></li>
												<li><label for="email-auth">Login with Email</label> <span
													class="pull-right"> <input type="checkbox"
														id="email-auth" name="my-checkbox">
												</span></li>
												<li><label for="update">Auto Update</label> <span
													class="pull-right"> <input type="checkbox"
														id="update" name="my-checkbox">
												</span></li>

											</ul>
											<h5 class="rightsidebar-right-heading text-uppercase text-xs">
												<i class="fa fa-fw ti-volume"></i> Sound & Notification
											</h5>
											<ul class="list-unstyled settings-list m-t-10">
												<li><label for="chat-sound">Chat Sound</label> <span
													class="pull-right"> <input type="checkbox"
														id="chat-sound" name="my-checkbox" checked>
												</span></li>
												<li><label for="noti-sound">Notification Sound</label>
													<span class="pull-right"> <input type="checkbox"
														id="noti-sound" name="my-checkbox">
												</span></li>
												<li><label for="remain">Remainder </label> <span
													class="pull-right"> <input type="checkbox"
														id="remain" name="my-checkbox" checked>
												</span></li>
												<li><label for="vol">Volume</label> <input type="range"
													id="vol" min="0" max="100" value="15"></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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
