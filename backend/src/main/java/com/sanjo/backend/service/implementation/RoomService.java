package com.sanjo.backend.service.implementation;


import com.sanjo.backend.dto.Response;
import com.sanjo.backend.dto.RoomDTO;
import com.sanjo.backend.dto.UserDTO;
import com.sanjo.backend.entity.Room;
import com.sanjo.backend.entity.User;
import com.sanjo.backend.exception.OurException;
import com.sanjo.backend.repository.BookingRepository;
import com.sanjo.backend.repository.RoomRepository;
import com.sanjo.backend.service.AwsS3Service;
import com.sanjo.backend.service.interfac.IRoomService;
import com.sanjo.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final AwsS3Service awsS3Service;

    public RoomService(RoomRepository roomRepository, BookingRepository bookingRepository, AwsS3Service awsS3Service) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.awsS3Service = awsS3Service;
    }

    @Override
    public Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description) {
        Response response = new Response();
        try {
            Room room = new Room();
            String imageUrl = awsS3Service.saveImageToS3(photo);
            room.setRoomPhotoUrl(imageUrl);
            room.setRoomType(roomType);
            room.setRoomDescription(description);
            room.setRoomPrice(roomPrice);

            Room savedRoom = roomRepository.save(room);
            RoomDTO dto = Utils.mapRoomEntityToRoomDTO(savedRoom);

            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setRoom(dto);
        }
        catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error Occurred While Adding Room "+e.getMessage());
        }
        return response;
    }

    @Override
    public List<String> getAllRoomTypes() {

        return roomRepository.findDistinctRoomTypes();
    }

    @Override
    public Response getAllRooms() {
        return null;
    }

    @Override
    public Response deleteRoom(Long roomId) {
        return null;
    }

    @Override
    public Response updateRoom(Long roomId, String description, String roomType, BigDecimal roomPrice, MultipartFile photo) {
        return null;
    }

    @Override
    public Response getRoomById(Long roomId) {
        return null;
    }

    @Override
    public Response getAvailableRoomsByDataAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        return null;
    }

    @Override
    public Response getAllAvailableRooms() {
        return null;
    }
}
