package com.pyf.house.entity.redis;


import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash("house.center.house")
public class HouseRedis {
    @Id
    String id;

    String houseName;

    String housePrice;
}
