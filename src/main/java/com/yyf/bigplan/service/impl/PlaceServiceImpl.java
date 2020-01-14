package com.yyf.bigplan.service.impl;

import com.yyf.bigplan.controller.request.AddAndModifyPlaceRequest;
import com.yyf.bigplan.controller.request.DelOnePlaceRequest;
import com.yyf.bigplan.controller.request.ModifyPlaceRequest;
import com.yyf.bigplan.controller.response.StatisticalResponse;
import com.yyf.bigplan.dao.PlaceRepository;
import com.yyf.bigplan.dao.UserRepository;
import com.yyf.bigplan.dto.PlaceDTO;
import com.yyf.bigplan.entity.Place;
import com.yyf.bigplan.entity.User;
import com.yyf.bigplan.enums.UserEnum;
import com.yyf.bigplan.service.PlaceService;
import com.yyf.bigplan.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨宇飞 2019-11-19 6:45 下午
 * @version 1.0
 * @apiNote <p>记录地区服务实现</p>
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PlaceDTO> getAll() {
        List<PlaceDTO> list = new ArrayList<>();
        placeRepository.findAll().forEach(i -> {
            PlaceDTO p = new PlaceDTO();
            p.setId(i.getId());
            p.setName(i.getName());
            p.setImgUrl(i.getImgURL());
            list.add(p);
        });
        return list;
    }

    @Override
    public void addOne(AddAndModifyPlaceRequest addAndModifyPlaceRequest) {
        Place p = new Place();
        p.setName(addAndModifyPlaceRequest.getPlaceName());
        placeRepository.save(p);
    }

    @Override
    public void modify(AddAndModifyPlaceRequest addAndModifyPlaceRequest) {
        placeRepository.findById(addAndModifyPlaceRequest.getPlaceId()).ifPresent(place -> {
            place.setName(addAndModifyPlaceRequest.getPlaceName());
            place.setUpdateTime(LocalDateTime.now());
            placeRepository.save(place);
        });
    }

    @Override
    public void delOne(DelOnePlaceRequest delOnePlaceRequest) {
        placeRepository.findById(delOnePlaceRequest.getPlaceId()).ifPresent(place -> placeRepository.delete(place));
    }

    @Override
    public StatisticalResponse statistical(String placeId) {
        // 根据place id 获取list
        Specification<User> specification = (Specification<User>) (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = criteriaBuilder.equal(root.get("addPlaceId"), Integer.valueOf(placeId));
            list.add(p);
            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };
        // 进行统计处理后返回
        return doStatistical(userRepository.findAll(specification));
    }

    @Override
    public void uploadImg(ModifyPlaceRequest modifyPlaceRequest) {
        // 1 保存图片到本地
        String uploadURL = Base64Utils.saveImg(modifyPlaceRequest.getFile());
        // 2 将PlaceId 和uploadURL 保存到数据库
        placeRepository.findById(Integer.valueOf(modifyPlaceRequest.getModifyId())).ifPresent(place -> {
            place.setImgURL(uploadURL);
            place.setUpdateTime(LocalDateTime.now());
            placeRepository.save(place);
        });

    }

    /**
     * 统计逻辑封装
     *
     * @param all 对应place id 的User 集合
     * @return {@link StatisticalResponse}
     */
    private StatisticalResponse doStatistical(List<User> all) {
        // 初始化统计数值
        int phone = 0, chat = 0, think = 0, look = 0, check = 0, other = 0; // 购买前行为
        int age1 = 0, age2 = 0, age3 = 0, age4 = 0, age5 = 0, age6 = 0; // 年龄
        int male = 0, female = 0; // 性别
        int time1 = 0, time2 = 0, time3 = 0, time4 = 0; // 时间段
        int wait1 = 0, wait2 = 0, wait3 = 0, wait4 = 0, wait5 = 0, wait6 = 0; // 等待时间
        int eff1 = 0, eff2 = 0, eff3 = 0, eff4 = 0, eff5 = 0, eff6 = 0; // 有效时间
        for (User u : all) {
            // 购买前行为
            if (u.getBuyBehavior().contains("" + UserEnum.BUY_PHONE.getCode())) {
                phone += 1;
            }
            if (u.getBuyBehavior().contains("" + UserEnum.BUY_CHAT.getCode())) {
                chat += 1;
            }
            if (u.getBuyBehavior().contains("" + UserEnum.BUY_THINK.getCode())) {
                think += 1;
            }
            if (u.getBuyBehavior().contains("" + UserEnum.BUY_LOOK.getCode())) {
                look += 1;
            }
            if (u.getBuyBehavior().contains("" + UserEnum.BUY_CHECK.getCode())) {
                check += 1;
            }
            if (!u.getBuyBehavior().matches(".*[0-9]+.*") || u.getBuyBehavior().length() > 0) {
                other += 1;
            }
            // 年龄
            if (u.getAge().contains("" + UserEnum.AGE_1.getCode())) {
                age1 += 1;
            }
            if (u.getAge().contains("" + UserEnum.AGE_2.getCode())) {
                age2 += 1;
            }
            if (u.getAge().contains("" + UserEnum.AGE_3.getCode())) {
                age3 += 1;
            }
            if (u.getAge().contains("" + UserEnum.AGE_4.getCode())) {
                age4 += 1;
            }
            if (u.getAge().contains("" + UserEnum.AGE_5.getCode())) {
                age5 += 1;
            }
            if (u.getAge().contains("" + UserEnum.AGE_6.getCode())) {
                age6 += 1;
            }
            // 性别
            if (u.getSex().contains("" + UserEnum.MALE.getCode())) {
                male += 1;
            } else {
                female += 1;
            }
            // 时间段
            if (9 <= u.getInTime().getHour() || u.getInTime().getHour() <= 12) {
                time1 += 1;
            }
            if (12 <= u.getInTime().getHour() || u.getInTime().getHour() <= 15) {
                time2 += 1;
            }
            if (15 <= u.getInTime().getHour() || u.getInTime().getHour() <= 18) {
                time3 += 1;
            }
            if (18 <= u.getInTime().getHour() || u.getInTime().getHour() <= 21) {
                time4 += 1;
            }
            // 等待时间
            if (0 <= u.getWaitTime() || u.getWaitTime() <= 30) {
                wait1 += 1;
            } else if (u.getWaitTime() <= 60) {
                wait2 += 1;
            } else if (u.getWaitTime() <= 90) {
                wait3 += 1;
            } else if (u.getWaitTime() <= 120) {
                wait4 += 1;
            } else if (u.getWaitTime() <= 160) {
                wait5 += 1;
            } else {
                wait6 += 1;
            }
            // 有效时间
            if (0 <= u.getEffectiveTime() || u.getEffectiveTime() <= 30) {
                eff1 += 1;
            } else if (u.getEffectiveTime() <= 60) {
                eff2 += 1;
            } else if (u.getEffectiveTime() <= 90) {
                eff3 += 1;
            } else if (u.getEffectiveTime() <= 120) {
                eff4 += 1;
            } else if (u.getEffectiveTime() <= 160) {
                eff5 += 1;
            } else {
                eff6 += 1;
            }
        }
        return StatisticalResponse.builder().buyBPhone(phone).buyBChat(chat).buyBThink(think).buyBLook(look).buyBCheck(check).buyBOther(other)
                .age1(age1).age2(age2).age3(age3).age4(age4).age5(age5).age6(age6)
                .male(male).female(female)
                .time1(time1).time2(time2).time3(time3).time4(time4)
                .wait1(wait1).wait2(wait2).wait3(wait3).wait4(wait4).wait5(wait5).wait6(wait6)
                .eff1(eff1).eff2(eff2).eff3(eff3).eff4(eff4).eff5(eff5).eff6(eff6)
                .build();
    }
}
