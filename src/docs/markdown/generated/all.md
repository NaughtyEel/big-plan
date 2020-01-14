# spring-boot-starter-swagger


<a name="overview"></a>
## Overview
Starter for swagger 2.x


### Version information
*Version* : 1.4.0.RELEASE


### Contact information
*Contact* : YangYuFei  
*Contact Email* : 951462260@qq.com


### License information
*License* : Apache License, Version 2.0  
*License URL* : https://www.apache.org/licenses/LICENSE-2.0.html  
*Terms of service* : https://github.com/dyc87112/spring-boot-starter-swagger


### URI scheme
*Host* : localhost:8888  
*BasePath* : /


### Tags

* 1-地区Api : Place Controller
* 2-观察目标用户Api : User Controller




<a name="paths"></a>
## Paths

<a name="addoneusingput"></a>
### 添加地区信息
```
PUT /place
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**addAndModifyPlaceRequest**  <br>*required*|addAndModifyPlaceRequest|[AddAndModifyPlaceRequest](#addandmodifyplacerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="deloneusingdelete"></a>
### 删除地区信息
```
DELETE /place
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**delOnePlaceRequest**  <br>*required*|delOnePlaceRequest|[DelOnePlaceRequest](#deloneplacerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="getallusingget"></a>
### 获取所有地区信息
```
GET /place/all
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse«List«PlaceDTO»»](#fe4bfbf7ceb79acd0b78f504ddcfc7b8)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="getimgusingget"></a>
### 修改user ，包括删除
```
GET /place/img
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**imgUrl**  <br>*required*|imgUrl|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="modifyoneusingpost"></a>
### 修改地区信息
```
POST /place/modify
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**addAndModifyPlaceRequest**  <br>*required*|addAndModifyPlaceRequest|[AddAndModifyPlaceRequest](#addandmodifyplacerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="getallusingget_1"></a>
### 获取对应placeId 的统计信息
```
GET /place/statistical
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**placeId**  <br>*required*|placeId|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse«StatisticalResponse»](#cbad1d3a357e37f486b5aef67eed7158)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="uploadimgusingpost"></a>
### 修改user ，包括删除
```
POST /place/uploadImg
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**modifyPlaceRequest**  <br>*required*|modifyPlaceRequest|[ModifyPlaceRequest](#modifyplacerequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 1-地区Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="getallusingget_2"></a>
### 获取所有目标用户信息
```
GET /user/all
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [观察目标用户实体类](#a329a1cc8cbe573b6eb41eb721956ad4) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="modifyusingpost"></a>
### 修改user ，包括删除
```
POST /user/modify
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**modifyUserRequest**  <br>*required*|modifyUserRequest|[ModifyUserRequest](#modifyuserrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="addmoreusingpost"></a>
### 一次性添加多个数据
```
POST /user/more
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**addMoreUserRequest**  <br>*required*|addMoreUserRequest|[AddMoreUserRequest](#addmoreuserrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="addoneusingpost"></a>
### 添加一个数据
```
POST /user/one
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**addOneUserRequest**  <br>*required*|addOneUserRequest|[AddOneUserRequest](#addoneuserrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse](#baseresponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="pageusingpost"></a>
### 条件查询所有User 对象并分页
```
POST /user/page
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**findPageUserRequest**  <br>*required*|findPageUserRequest|[FindPageUserRequest](#findpageuserrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[BaseResponse«Page«观察目标用户实体类»»](#9b23f8f58b6a3541eda6ccb1872a7ce7)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|


<a name="testusingget"></a>
### 条件查询所有User 对象并分页
```
GET /user/test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 2-观察目标用户Api


#### Security

|Type|Name|Scopes|
|---|---|---|
|**apiKey**|**[Authorization](#authorization)**|global|




<a name="definitions"></a>
## Definitions

<a name="addandmodifyplacerequest"></a>
### AddAndModifyPlaceRequest

|Name|Description|Schema|
|---|---|---|
|**placeId**  <br>*optional*|记录地点ID|integer (int32)|
|**placeName**  <br>*optional*|记录地点名称|string|


<a name="addmoreuserrequest"></a>
### AddMoreUserRequest

|Name|Description|Schema|
|---|---|---|
|**ageValues**  <br>*optional*|年龄|< string > array|
|**attributeFeature**  <br>*optional*|属性特征|< string > array|
|**buyBehavior**  <br>*optional*|购买前行为|< string > array|
|**buyBehaviorOther**  <br>*optional*|购买前行为其他项|string|
|**effectiveTime**  <br>*optional*|有效时间|integer (int32)|
|**looksFeatures**  <br>*optional*|体态特征|< string > array|
|**occupationValues**  <br>*optional*|职业|< string > array|
|**placeId**  <br>*optional*|记录地点ID|integer (int32)|
|**sexValues**  <br>*optional*|性别|< string > array|
|**spend**  <br>*optional*|花费|integer (int32)|
|**teamNumber**  <br>*optional*|组队人数|integer (int32)|
|**waitTime**  <br>*optional*|等待时间|integer (int32)|
|**wearingFeatures**  <br>*optional*|穿着|< string > array|
|**wearingOther**  <br>*optional*|穿着其他项|string|


<a name="addoneuserrequest"></a>
### AddOneUserRequest

|Name|Description|Schema|
|---|---|---|
|**ageValue**  <br>*optional*|年龄|string|
|**attributeFeature**  <br>*optional*|属性特征|< string > array|
|**buyBehavior**  <br>*optional*|购买前行为|< string > array|
|**buyBehaviorOther**  <br>*optional*|购买前行为其他项|string|
|**effectiveTime**  <br>*optional*|有效时间|integer (int32)|
|**looksFeature**  <br>*optional*|体态特征|string|
|**occupationValue**  <br>*optional*|职业|string|
|**placeId**  <br>*optional*|记录地点ID|integer (int32)|
|**sexValue**  <br>*optional*|性别|string|
|**spend**  <br>*optional*|花费|integer (int32)|
|**waitTime**  <br>*optional*|等待时间|integer (int32)|
|**wearingFeatures**  <br>*optional*|穿着|< string > array|
|**wearingOther**  <br>*optional*|穿着其他项|string|


<a name="baseresponse"></a>
### BaseResponse

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**info**  <br>*optional*|object|
|**msg**  <br>*optional*|string|


<a name="fe4bfbf7ceb79acd0b78f504ddcfc7b8"></a>
### BaseResponse«List«PlaceDTO»»

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**info**  <br>*optional*|< [PlaceDTO](#placedto) > array|
|**msg**  <br>*optional*|string|


<a name="9b23f8f58b6a3541eda6ccb1872a7ce7"></a>
### BaseResponse«Page«观察目标用户实体类»»

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**info**  <br>*optional*|[Page«观察目标用户实体类»](#619b83ee1e1b4c77b1440899ddabf34a)|
|**msg**  <br>*optional*|string|


<a name="cbad1d3a357e37f486b5aef67eed7158"></a>
### BaseResponse«StatisticalResponse»

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**info**  <br>*optional*|[StatisticalResponse](#statisticalresponse)|
|**msg**  <br>*optional*|string|


<a name="deloneplacerequest"></a>
### DelOnePlaceRequest

|Name|Description|Schema|
|---|---|---|
|**placeId**  <br>*optional*|记录地点ID|integer (int32)|


<a name="findpageuserrequest"></a>
### FindPageUserRequest

|Name|Description|Schema|
|---|---|---|
|**attributeFeatures**  <br>*optional*|属性特征|string|
|**buyBehavior**  <br>*optional*|购买前行为|string|
|**currentPage**  <br>*optional*|页数|integer (int32)|
|**effectiveTimeEnd**  <br>*optional*|有效时间结束|integer (int32)|
|**effectiveTimeStart**  <br>*optional*|有效时间开始|integer (int32)|
|**looksFeatures**  <br>*optional*|外貌特征|string|
|**pageSize**  <br>*optional*|页面显示条数|integer (int32)|
|**sex**  <br>*optional*|性别|integer (int32)|
|**spendEnd**  <br>*optional*|花费右区间|integer (int32)|
|**spendStart**  <br>*optional*|花费左区间|integer (int32)|
|**teamNum**  <br>*optional*|组队人数|integer (int32)|
|**teamUuid**  <br>*optional*|用户组队的编号|string|
|**uuid**  <br>*optional*|用户编号|string|
|**waitTimeEnd**  <br>*optional*|等待时间结束|integer (int32)|
|**waitTimeStart**  <br>*optional*|等待时间开始|integer (int32)|
|**wearingFeatures**  <br>*optional*|穿着|string|


<a name="modifyplacerequest"></a>
### ModifyPlaceRequest

|Name|Description|Schema|
|---|---|---|
|**file**  <br>*optional*|图片|string|
|**modifyId**  <br>*optional*|记录地点Id|string|


<a name="modifyuserrequest"></a>
### ModifyUserRequest

|Name|Description|Schema|
|---|---|---|
|**modifyDelete**  <br>*optional*|删除标记|integer (int32)|
|**modifyEffTime**  <br>*optional*|有效时间|integer (int32)|
|**modifyId**  <br>*optional*|对象Id|string|
|**modifySpend**  <br>*optional*|消费金额|integer (int32)|
|**modifyWaitTime**  <br>*optional*|等待时间|integer (int32)|


<a name="pageable"></a>
### Pageable

|Name|Schema|
|---|---|
|**offset**  <br>*optional*|integer (int64)|
|**pageNumber**  <br>*optional*|integer (int32)|
|**pageSize**  <br>*optional*|integer (int32)|
|**paged**  <br>*optional*|boolean|
|**sort**  <br>*optional*|[Sort](#sort)|
|**unpaged**  <br>*optional*|boolean|


<a name="619b83ee1e1b4c77b1440899ddabf34a"></a>
### Page«观察目标用户实体类»

|Name|Schema|
|---|---|
|**content**  <br>*optional*|< [观察目标用户实体类](#a329a1cc8cbe573b6eb41eb721956ad4) > array|
|**first**  <br>*optional*|boolean|
|**last**  <br>*optional*|boolean|
|**number**  <br>*optional*|integer (int32)|
|**numberOfElements**  <br>*optional*|integer (int32)|
|**pageable**  <br>*optional*|[Pageable](#pageable)|
|**size**  <br>*optional*|integer (int32)|
|**sort**  <br>*optional*|[Sort](#sort)|
|**totalElements**  <br>*optional*|integer (int64)|
|**totalPages**  <br>*optional*|integer (int32)|


<a name="placedto"></a>
### PlaceDTO

|Name|Schema|
|---|---|
|**id**  <br>*optional*|integer (int32)|
|**imgUrl**  <br>*optional*|string|
|**name**  <br>*optional*|string|


<a name="sort"></a>
### Sort

|Name|Schema|
|---|---|
|**sorted**  <br>*optional*|boolean|
|**unsorted**  <br>*optional*|boolean|


<a name="statisticalresponse"></a>
### StatisticalResponse

|Name|Description|Schema|
|---|---|---|
|**age1**  <br>*optional*|年龄：小学生|integer (int32)|
|**age2**  <br>*optional*|年龄：中学生|integer (int32)|
|**age3**  <br>*optional*|年龄：大学生|integer (int32)|
|**age4**  <br>*optional*|年龄：青年|integer (int32)|
|**age5**  <br>*optional*|年龄：中年|integer (int32)|
|**age6**  <br>*optional*|年龄：老年|integer (int32)|
|**buyBChat**  <br>*optional*|购买前行为：聊天|integer (int32)|
|**buyBCheck**  <br>*optional*|购买前行为：检查优惠|integer (int32)|
|**buyBLook**  <br>*optional*|购买前行为：浏览商品|integer (int32)|
|**buyBOther**  <br>*optional*|购买前行为：其他|integer (int32)|
|**buyBPhone**  <br>*optional*|购买前行为：玩手机|integer (int32)|
|**buyBThink**  <br>*optional*|购买前行为：发呆|integer (int32)|
|**eff1**  <br>*optional*|有效时间：30s|integer (int32)|
|**eff2**  <br>*optional*|有效时间：60s|integer (int32)|
|**eff3**  <br>*optional*|有效时间：90s|integer (int32)|
|**eff4**  <br>*optional*|有效时间：120s|integer (int32)|
|**eff5**  <br>*optional*|有效时间：160s|integer (int32)|
|**eff6**  <br>*optional*|有效时间：160s+|integer (int32)|
|**female**  <br>*optional*|年龄：女性|integer (int32)|
|**male**  <br>*optional*|性别：男性|integer (int32)|
|**time1**  <br>*optional*|时间段：上午9点-12点|integer (int32)|
|**time2**  <br>*optional*|时间段：中午12点-3点|integer (int32)|
|**time3**  <br>*optional*|时间段：下午3点-6点|integer (int32)|
|**time4**  <br>*optional*|时间段：下午6点-晚间9点|integer (int32)|
|**wait1**  <br>*optional*|等待时间：30s|integer (int32)|
|**wait2**  <br>*optional*|等待时间：60s|integer (int32)|
|**wait3**  <br>*optional*|等待时间：90s|integer (int32)|
|**wait4**  <br>*optional*|等待时间：120s|integer (int32)|
|**wait5**  <br>*optional*|等待时间：160s|integer (int32)|
|**wait6**  <br>*optional*|等待时间：160s+|integer (int32)|


<a name="a329a1cc8cbe573b6eb41eb721956ad4"></a>
### 观察目标用户实体类

|Name|Description|Schema|
|---|---|---|
|**addPlaceId**  <br>*optional*|记录地点id 不能为NULL|integer (int32)|
|**age**  <br>*optional*|年龄（0 小学生 1 中学生 2 大学生 3 青年 4 中年 5 老年）多人时用英文逗号隔开|string|
|**attributeFeatures**  <br>*optional*|属性特征（0 情侣 1 外国人 2 拎着很多东西 3 家庭成员）多人时按顺序逗号隔开|string|
|**buyBehavior**  <br>*optional*|购买前行为（0 玩手机 1 聊天 2 发呆 3 浏览展品 4 检查优惠 其他）多人时取普遍行为|string|
|**effectiveTime**  <br>*optional*|展区视野停留时间（单位：秒）|integer (int32)|
|**id**  <br>*optional*|主键id|integer (int32)|
|**inTime**  <br>*optional*|进店时间|string (date-time)|
|**isBuy**  <br>*optional*|是否购买（0 否 1 是）|integer (int32)|
|**isTeam**  <br>*optional*|是否组队（0 否 1 是）|integer (int32)|
|**looksFeatures**  <br>*optional*|外貌特征（0 胖 1 中等身材 2 瘦）多人时按顺序以英文逗号隔开|string|
|**occupation**  <br>*optional*|职业 多人时用英文逗号隔开|string|
|**sex**  <br>*optional*|性别（0 男 1 女）多人时用英文逗号隔开|string|
|**spend**  <br>*optional*|花费金额（单位：元）|integer (int32)|
|**teamNum**  <br>*optional*|组队人数（默认为0）|integer (int32)|
|**teamUuid**  <br>*optional*|用户组队的唯一编号|string|
|**updateTime**  <br>*optional*|默认更新时间|string (date-time)|
|**uuid**  <br>*optional*|用户唯一编号 不能为NULL|string|
|**waitTime**  <br>*optional*|等待时间（单位：秒）|integer (int32)|
|**wearingFeatures**  <br>*optional*|穿着特征（0 正式 1 休闲 2 华贵 3 运动 其他）多人时按顺序以英文逗号隔开|string|




<a name="securityscheme"></a>
## Security

<a name="authorization"></a>
### Authorization
*Type* : apiKey  
*Name* : TOKEN  
*In* : HEADER



