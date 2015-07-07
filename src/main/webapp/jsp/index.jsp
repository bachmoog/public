<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div  class="container">
            <div class="row">
                <div class="col-lg-8 panel" style="border: 2px solid black; padding-top: 10px; padding-bottom: 10px">
                    <div class="row">
                        <div id="0" >
                            <img id="img0" src="${pageContext.request.contextPath}/img/LaysClassic.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img0_slide" src="${pageContext.request.contextPath}/img/LaysClassic.jpg" style="position:absolute; left: 0; top: 2%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))" />
                        </div>
                        <div id="1" >
                            <img id="img1"  src="${pageContext.request.contextPath}/img/HawaiianLuauBBQRings.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img1_slide" src="${pageContext.request.contextPath}/img/HawaiianLuauBBQRings.jpg" style="position:absolute; left: 25%; top: 2%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                        <div id="2">
                            <img id="img2"  src="${pageContext.request.contextPath}/img/ChexMixTraditional.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img2_slide" src="${pageContext.request.contextPath}/img/ChexMixTraditional.jpg" style="position:absolute; left: 50%; top: 2%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>

                        <div id="3">
                            <img id="img3"  src="${pageContext.request.contextPath}/img/ChexMixSweetSalty.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img3_slide" src="${pageContext.request.contextPath}/img/ChexMixSweetSalty.jpg" style="position:absolute; left: 75%; top: 2%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <p align="center" id="cost0"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost1"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost2"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost3"></p>
                        </div>                   
                    </div>
                    <br>
                    <div class="row">
                        <div id="4" >
                            <img id="img4" src="${pageContext.request.contextPath}/img/Hershey.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img4_slide" src="${pageContext.request.contextPath}/img/Hershey.jpg" style="position:absolute; left: 0; top: 35%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))" />
                        </div>
                        <div id="5">
                            <img id="img5"  src="${pageContext.request.contextPath}/img/Snickers.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img5_slide" src="${pageContext.request.contextPath}/img/Snickers.jpg" style="position:absolute; left: 25%; top: 35%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                        <div id="6">
                            <img id="img6"  src="${pageContext.request.contextPath}/img/MilkyWay.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img6_slide" src="${pageContext.request.contextPath}/img/MilkyWay.jpg" style="position:absolute; left: 50%; top: 35%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                        <div id="7">
                            <img id="img7"  src="${pageContext.request.contextPath}/img/KitKat.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img7_slide" src="${pageContext.request.contextPath}/img/KitKat.jpg" style="position:absolute; left: 75%; top: 35%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <p align="center" id="cost4"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost5"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost6"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost7"></p>
                        </div>                   
                    </div>
                    <div class="row">
                        <div id="8">
                            <img id="img8" src="${pageContext.request.contextPath}/img/OrbitSpearmint.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img8_slide" src="${pageContext.request.contextPath}/img/OrbitSpearmint.jpg" style="position:absolute; left: 0; top: 64%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))" />
                        </div>
                        <div id="9">
                            <img id="img9"  src="${pageContext.request.contextPath}/img/OrbitWinterMint.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img9_slide" src="${pageContext.request.contextPath}/img/OrbitWinterMint.jpg" style="position:absolute; left: 25%; top: 64%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                        <div id="10">
                            <img id="img10"  src="${pageContext.request.contextPath}/img/BreathSaversSpearmint.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img10_slide" src="${pageContext.request.contextPath}/img/BreathSaversSpearmint.jpg" style="position:absolute; left: 50%; top: 64%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                        <div id="11">
                            <img id="img11"  src="${pageContext.request.contextPath}/img/BreathSaversWintergreen.jpg"
                                 class="img-responsive col-sm-3" style="position:relative" />
                            <img id="img11_slide" src="${pageContext.request.contextPath}/img/BreathSaversWintergreen.jpg" style="position:absolute; left: 75%; top: 64%;z-index: 999"
                                 class="img-responsive col-sm-3" onclick="itemSelected($(this).attr('id'))"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <p align="center" id="cost8"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost9"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost10"></p>
                        </div>
                        <div class="col-sm-3">
                            <p align="center" id="cost11"></p>
                        </div>                   
                    </div>

                </div>
                <div class="col-lg-4 panel" style="border: 2px solid black; padding-top: 25px; padding-bottom: 25px">
                        <!-- Money input label and textbox-->
                        <div class="form-group" style="border: 1px solid black">
                            <div class="row">
                                <div id="userMoneyInput" class="form-horizontal">
                                    <label class="col-sm-3 control-label">Money</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="userMoney" id="userMoney">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <button type="button" id="enterMoney" class="col-sm-offset-4 col-sm-5 btn">
                                    Enter Money
                                </button>
                            </div>
                        </div>

                    <!-- User message display-->
                    <div class="form-group" style="border: 1px solid black">
                        <form id="userQueryResponse" action="response" method="GET">
                            <div class="row form-horizontal">
                                <label class="col-sm-3 control-label">Message</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" id="userMessage" name="userMessage">
                                    </textarea>
                                </div>
                            </div>
                            <div class="row form-horizontal">
                                <button type="button" id="vend" name="vend" value="Vend" class="col-sm-offset-4 col-sm-3 btn" >Vend  </button>
                                <button type="button" id="exit" name="exit" value="Exit" class="col-sm-offset-1 col-sm-3 btn" >Exit  </button>
                            </div>
                        </form>    
                    </div>
                    <div class="form-group" style="border: 1px solid black">
                        <div class="row form-horizontal">
                            <div class="col-sm-3">
                                <label class="control-label">Money Returned</label>
                            </div>
                            <div class="col-sm-7" id="userMoneyReturned">
                                <div class="row form-horizontal">
                                    <p class="col-sm-4" >Quarters:</p>
                                    <p class="col-sm-3" id="quarters">0</p>
                                </div>
                                <div class="row form-horizontal">
                                    <p class="col-sm-4">Dimes:</p>
                                    <p class="col-sm-3" id="dimes">0</p>
                                </div>
                                <div class="row form-horizontal">
                                    <p class="col-sm-4">Nickels:</p>
                                    <p class="col-sm-3" id="nickels">0</p>
                                </div>
                                <div class="row form-horizontal">
                                    <p class="col-sm-4" >Pennies:</p>
                                    <p class="col-sm-3" id="pennies">0</p>
                                </div>
                            </div>    
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="border: 1px solid black">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </div>
        </div>



        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingmachine.js"></script>

    </body>
</html>

