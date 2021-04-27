# Challenge Golden Pocket
_[Yahya Faikar Hanif]_

## Database: 

Menggunakan database yang sama dengan gold_pocket terdahulu, namun untuk challenge kali ini terdapat tambahan pada tabel _t_purchases_, yaitu penambahan column purchase_type. Dalam kolom tersebut berisi tipe data integer dengan kode 0 untuk pembelian dan 1 untuk penjualan.


## Penggunaan REST API: 

Penggunaan REST API sesuai dengan ketentuan pada challenge:


### _Sebuah pocket dapat melihat detail pocket:_
- GET pocket berdasarkan ID
Gunakan path localhost:8080/pocket/{id} dengan method GET. Masukkan id pocket pada path, tidak menerima input pada body.

### _Dapat melihat list of pocket dari customer tertentu:_
- GET semua pocket pada customer tertentu
Menggunakan subresource. Gunakan path localhost:8080/customer/{id}/pockets dengan method GET. Masukkan id customer pada path, tidak menerima input pada body.

### _Dapat melihat list of purchase:_
- GET semua purchase
Gunakan path localhost:8080/purchases dengan method GET. Dapat menerima berbagai Request Parameter. Untuk menampilkan halaman gunakan _page_, memiliki _default value_ 0 (halaman 1). Untuk mengatur banyaknya konten dalam setiap halaman gunakan _size_, memiliki _default value_ 5 (satu halaman 5 konten). Dapat juga mengatur prioritas urutan dengan memanfaatkan _sortBy_ untuk menemtukan urutan akan dilakukan berdasarkan column apa (_default value_ = purchaseDate). Dan juga menentukan arah urutan dengan request parameter _direction_, dapate memilih antara DESC (_descending_) atau ASC (_ascending_) memiliki _default value_ ASC.

### _Tambahkan fitur jual beli product_
- POST method purchase dengan _purchaseType_ 1 (Sell/Jual)
Dalam satu kali transaksi, kita dapat memilih 1 atau lebih pocket yang isinya akan dijual. Gunakan path localhost:8080/purchase dengan method POST. Menerima input pada body sebagai berikut. Apabila ingin menjual pada 3 pocket sekaligus, tambahkan pada array purchaseDetails.
 
```sh
{
    "purchaseType": 1 (untuk menjual),
    "purchaseDetails": [
        {
            "quantityInGram": float (jumlah product yang dijual),
            "pocket":{ 
                "id":"pocket_id"
            } 
        },
        {
            "quantityInGram": float (jumlah product yang dijual),
            "pocket":{ 
                "id":"pocket_id"
            }  
        }
    ]
}
```

- POST method purchase dengan _purchaseType_ 0 (Buy/Beli)
Dalam satu kali transaksi, kita dapat memilih 1 atau lebih pocket yang isinya akan dibeli. Gunakan path localhost:8080/purchase dengan method POST. Menerima input pada body sebagai berikut. Apabila ingin membeli untuk 3 pocket sekaligus, tambahkan pada array purchaseDetails.

```sh
{
    "purchaseType": 0 (untuk membeli),
    "purchaseDetails": [
        {
            "quantityInGram": float (jumlah product yang dibeli),
            "pocket":{ 
                "id":"pocket_id"
            } 
        },
        {
            "quantityInGram": float (jumlah product yang dibeli),
            "pocket":{ 
                "id":"pocket_id"
            }  
        }
    ]
}
```

# NOTE
_Belum ada fitur advance searching form menggunakan JPA Spesification Executor_

