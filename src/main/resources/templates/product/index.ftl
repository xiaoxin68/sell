<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--&lt;#&ndash;边栏sidebar&ndash;&gt;-->
<#include "../common/nav.ftl">

<#--&lt;#&ndash;主要内容content&ndash;&gt;-->
  <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" enctype="multipart/form-data" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" type="text" class="form-control" value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control" value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="number" class="form-control" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                           <div id="preview" style="height: 110px;margin-top: 5px;margin-bottom: 5px;">
                            <#if (productInfo.productIcon)??>
                                    <img  id="imghead" border="0" height="100px" width="100px" src="${(productInfo.productIcon)!''}" onclick="$('#previewImg').click();">
                                <#else>
                                    <img id="imghead" border="0" height="100px" width="100px" src="/sell/image/update.png"  onclick="$('#previewImg').click();">
                            </#if>
                            </div>
                               <#-- 预览图片-->
                               <input type="file" name="uploadFile" value="" onchange="previewImage(this)"  style="display: none;" id="previewImg" >
                               <#-- 图片地址-->
                               <input name="productIcon" type="hidden" class="form-control" value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                        >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/sell/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/sell/js/content_lbt.js"></script>
</body>
</html>



