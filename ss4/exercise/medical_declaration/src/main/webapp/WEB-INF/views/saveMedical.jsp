<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span {
            color: red;
        }

        /**{*/
        /*    width: 100%;*/
        /*}*/
    </style>
</head>
<body>
<form:form action="/save" method="post" modelAttribute="medical">
    <div>
        <div style="text-align: center">
            <h2>TỜ KHAI Y TẾ</h2>
            <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
                CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
            <h3 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
                sự</h3>
        </div>
        <div>
            <label>Họ tên(ghi chữ IN HOA) <span>(*)</span></label>
            <form:input path="name"></form:input>
        </div>
        <div>
            <div>
                <label>Năm sinh <span>(*)</span></label><br>
                <form:input path="yearOfBirt"></form:input>
            </div>
            <div>
                <label>Giới tính <span>(*)</span></label><br>
                <form:select path="gender">
                    <option value="Nữ">Nữ</option>
                    <option value="Nam">Nam</option>
                </form:select>
            </div>
            <div>
                <label>Quốc tịch <span>(*)</span></label>
                <form:select path="nationality" items="${nationality}"></form:select>
            </div>
        </div>
        <div>
            <label>Số hộ khẩu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span>(*)</span></label>
            <form:input path="idCard"></form:input>
        </div>
        <div>
            <label>Thông tin đi lại <span>(*)</span></label>
            <form:radiobuttons path="transport" items="${transport}"></form:radiobuttons>
        </div>
        <div style="display: flex">
            <div>
                <label>Số hiệu phương tiện</label>
                <form:input path="idVehicle" type="text"></form:input>
            </div>
            <div>
                <label>Số ghế</label>
                <form:input path="idSeat" type="text"></form:input>
            </div>
        </div>
        <div>
            <table>
                <tr>
                    <td>
                        <label>Ngày khởi hành <span>(*)</span></label><br>
                        <form:select path="dayStart" items="${day}"></form:select>
                        <form:select path="monthStart" items="${month}"></form:select>
                        <form:select path="yearStart" items="${year}"></form:select>
                    </td>
                    <td>
                        <label>Ngày kết thúc <span>(*)</span></label><br>
                        <form:select path="dayEnd" items="${day}"></form:select>
                        <form:select path="monthEnd" items="${month}"></form:select>
                        <form:select path="yearEnd" items="${year}"></form:select>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành nào?<span>(*)</span></label><br>
            <form:input path="city" type="text"></form:input>
        </div>
        <div style="text-align: center">
            <p style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phúc vụ cho việc phòng chống dịch thuộc
                quản
                lý của ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.
                Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
            <button type="submit">GỬI TỜ KHAI</button>
        </div>

    </div>
</form:form>
</body>
</html>
