1.Đầu Tiên Hãy Chạy file FinalCommit để lấy dữ liệu từ sql
2.Sửa Đổi Ở Package service, DBConnect.java Sửa Đổi DBname và PassWord
2.Bật Project Chọn Run project
Nhập tên đăng nhập và mật khẩu rồi bấm đăng nhập lưu ý (mật khẩu và tên đăng nhập có thể lấy trong database)
sẽ có 2 giao diện khác nhau
khi bạn đăng nhập bằng account quản lý thì giao diện sẽ hiển thị đầy đủ tất cả các chức năng
Khi bạn Đăng nhập bằng account nhân viên thì giao diện sẽ chỉ hiển thị 1 số chức năng
3.
*Trong Giao Diên Hãy Chọn Vào nút Chức năng mà mình muốn sử dụng
-Trong Chức Năng Quản Lý Sản Phẩm:
  +nếu muốn hiển thị sản phẩm nào lên form thì hãy click vào sản phẩm đó trong bảng
  +nếu muốn thêm sản phẩm thì hãy điền vào form nếu sai sẽ có thông báo lỗi 
  +nếu muốn sửa trạng thái bán từ đang bán sang ngừng bán hãy click vào sản phẩm đó trong bảng và bấm thay đổi trạng thái bán
  +nếu muốn tìm kiếm sản phẩm hãy nhập vào id mình cần tìm và bảng sẽ thay đổi giúp bạn tìm thấy nó
-Trong chức năng sản phẩm chi tiết:
  +Nếu muốn hiển thị chi tiết sản phẩm nào lên form thì hãy click vào chi tiết sản phẩm đó ở bảng dưới cùng
  +nếu muốn thêm sản phẩm chi tiết thì hãy điền vào form rồi bấm nút thêm nếu sai sẽ có thông báo lỗi
  +nếu muốn tìm kiếm sản phẩm Chi Tiết Theo Mã Sản Phẩm chi tiết hãy nhập vào id 
   mình cần tìm rồi bấm nút tìm kiếm và bảng sẽ giúp bạn tìm thấy nó
  +nếu muốn tìm kiếm sản phẩm Chi Tiết theo mã Sản phẩm hãy nhập vào id mình cần tìm 
   rồi bấm vào nút tìm và bảng sẽ giúp bạn tìm thấy nó
  +nếu muốn sửa sản phẩm chi tiết thì hãy click vào sản phẩm chi tiết đó ở bảng dưới cùng và điền lên form thay đổi mình muốn rồi bấm nút sửa
  +nếu muốn xóa sản phẩm chi tiết thì hãy click vào sản phẩm chi tiết đó ở bảng dưới cùng và bấm nút xóa
 -Trong chức năng quản lý hóa đơn hãy click vào hóa đơn mình cần tìm và bấm vào nó để xem danh mục sản phẩm bên trong
 -Trong chức năng quản lý khuyến mại 
   +nếu muốn hiển thị khuyến mãi nào hãy click vào khuyến mại đó trong bảng
   +nếu muốn tìm kiếm khuyến mãi theo mã Sản phẩm hãy nhập vào id mình cần tìm 
   rồi bấm vào nút tìm và bảng sẽ giúp bạn tìm thấy nó
   +nếu muốn thêm khuyến mãi thì hãy điền vào form rồi bấm thêm nếu sai sẽ có thông báo lỗi 
   +nếu muốn sửa sản phẩm chi tiết thì hãy click vào sản phẩm chi tiết đó ở và điền lên form thay đổi mình muốn rồi bấm nút sửa
 -Trong chức năng quản thuộc tính
   +Nếu muốn Hiển thị thuộc tính nào hãy click vào thuộc tính đó trong bảng thuộc tính tương ứng
   +nếu muốn thêm Thuộc tính nào thì hãy điền vào form tương ứng ở bên trái nếu sai sẽ có thông báo lỗi
   +nếu muốn sửa Thuộc tính nào thì hãy điền vào form tương ứng ở bên trái nếu sai sẽ có thông báo lỗi
 -Trong chức năng bán hàng tại quầy:
   +Nếu Muốn Tạo hóa đơn hãy bấm tạo hóa đơn
   +Nếu muốn xóa hóa đơn hãy chọn hóa đơn muốn xóa trong bảng đầu tiên và bấm nút xóa hóa đơn
   +Nếu muốn hiển thị giỏ hàng bên trong hãy chọn hóa đơn cần hiển thị giỏ hàng ở bảng đầu tiên
   +nếu muốn thêm số lượng sản phẩm vào giỏ hàng thì hãy chọn hóa đơn cần thêm,chọn sản phẩm cần thêm nhập số lượng rồi bấm OK là sẽ thêm được
   +nếu muốn sửa số lượng hãy chọn sản phẩm cần sửa số lượng trong giỏ hàng rồi bấm sửa số lượng, nhập số lượng muốn sửa và bấm OK
   +nếu muốn xóa sản phẩm ra khỏi giỏ hàng hãy chọn hóa đơn muốn xóa bấm vào sản phẩm muốn xóa trong giỏ hàng rồi nháy 2 lần chuột trái rồi bấm Yes
   +nếu muốn tìm kiếm sản phẩm thì hãy điền mã sản phẩm vào ô tìm kiếm rồi bấm tìm
   +nếu muốn áp mã khuyến mãi vào trong hóa đơn thì hãy chọn hóa đơn cần áp mã và chọn mã khuyến mãi cần áp ở bên phải và bấm áp mã
   +nếu muốn thanh toán thì hãy chọn hóa đơn cần thanh toán và bấm thanh toán
 -Trong chức năng Quản lý nhân viên
   +nếu muốn hiển thị nhân viên lên form thì hãy chọn nhân viên bên trong bảng
   +nếu muốn thêm nhân viên thì hãy điền vào form và bấm thêm nếu sai sẽ hiển  thị lỗi
   +nếu muốn sửa nhân viên thì hãy chọn nhân viên cần sửa và điền thông tin cần sửa ở trên form rồi bấm nút sửa
   +nếu muốn xóa nhân viên thì hãy chọn nhân viên cần xóa và bấm nút xóa
   +nếu muốn tìm nhân viên thì hãy Điền Mã nhân viên muốn tìm vào ô tìm kiếm và bấm nút tìm kiếm
 -Nếu muốn đăng xuất khỏi tài khoản thì hãy bấm đăng xuất và chọn yes