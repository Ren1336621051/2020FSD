export class Product {
  id: string;
  title: string;
  category: string;
  subcategory: string;
  price: string;
  qty:number;
  desc: string;
  stockNo: string;
  imgUrl1: string;
  imgUrl2: string;
  imgUrl3: string;
  seller: string;
  crtDate: string;
  // status: string;
  // buyer: string;
  // updateDate: string;
  // transactionNo: string
}
export class Category {
  categoryId: string;
  categoryName: string;
  detail: string
}
export class Subcategory {
  subcategoryId: string;
  subcategoryName: string;
  categoryId: string;
  detail: string;
  gst: number
}