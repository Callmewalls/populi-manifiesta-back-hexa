package com.example.demo.location_related.location.application.ports.in;

import com.example.demo.location_related.location.domain.Location;


public interface PostLocationUseCase {
    
    Location createLocation(Location location);
}
