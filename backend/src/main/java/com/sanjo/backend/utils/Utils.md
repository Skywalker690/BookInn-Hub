# 🛠️ Utils Class Summary - Hotel Booking Backend

The `Utils` class provides helper methods to convert **Entity** objects (from database) into **DTOs** (for frontend/API). This ensures only the needed information is exposed.

---

## 📌 Core Methods

### 🔐 generateRandomConfirmationCode(int length)
- **Purpose:** Generate a unique random confirmation code (like `AB12CD`) for bookings.

---

### 👤 mapUserEntityToUserDTO(User user)
- **Converts:** `User` ➝ `UserDTO`
- **Includes:** id, name, email, phone, role
- **Excludes:** bookings and room details

---

### 🏨 mapRoomEntityToRoomDTO(Room room)
- **Converts:** `Room` ➝ `RoomDTO`
- **Includes:** id, price, type, photo, description

---

### 📅 mapBookingEntityToBookingDTO(Booking booking)
- **Converts:** `Booking` ➝ `BookingDTO`
- **Includes:** id, guest count, check-in/out, confirmation code
- **Excludes:** user and room

---

### 🏨➕📅 mapRoomEntityToRoomDTOPlusBookings(Room room)
- **Converts:** `Room` ➝ `RoomDTO`
- **Adds:** Bookings of that room
- **Uses:** `mapBookingEntityToBookingDTO()` internally

---

### 📅➕🏨 mapBookingEntityToBookingDTOPlusBookedRooms(Booking booking, boolean mapUser)
- **Converts:** `Booking` ➝ `BookingDTO`
- **Adds:** Room info inside each booking
- **Conditionally Adds:** User info (if `mapUser = true`)
- **Uses:** `mapUserEntityToUserDTO()` and creates `RoomDTO`

---

### 👤➕📅➕🏨 mapUserEntityToUserDTOPlusUserBookingsAndRoom(User user)
- **Converts:** `User` ➝ `UserDTO`
- **Adds:** Bookings with nested room info
- **Uses:** `mapBookingEntityToBookingDTOPlusBookedRooms()`

---

