package com.yyf.bigplan.service.impl;

import com.yyf.bigplan.controller.request.AddMoreUserRequest;
import com.yyf.bigplan.controller.request.AddOneUserRequest;
import com.yyf.bigplan.controller.request.FindPageUserRequest;
import com.yyf.bigplan.controller.request.ModifyUserRequest;
import com.yyf.bigplan.dao.UserRepository;
import com.yyf.bigplan.entity.User;
import com.yyf.bigplan.enums.UserEnum;
import com.yyf.bigplan.enums.classEnum.PageStateEnum;
import com.yyf.bigplan.service.UserService;
import com.yyf.bigplan.util.UniqueNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨宇飞 2019-11-20 11:44 下午
 * @version 1.0
 * @apiNote <p>观察对象用户服务实现类</p>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getPage(FindPageUserRequest findPageUserRequest) {
        Pageable pageable = PageRequest.of(
                findPageUserRequest.getCurrentPage() == 0 ? PageStateEnum.currentPage :
                        findPageUserRequest.getCurrentPage(),
                findPageUserRequest.getPageSize() == 0 ? PageStateEnum.pageSize : findPageUserRequest.getPageSize());
        Specification<User> specification = (Specification<User>) (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            // ----动态查询条件----
            // 1.用户编号
            if (!StringUtils.isEmpty(findPageUserRequest.getUuid())) {
                Predicate p = criteriaBuilder.equal(root.get("uuid"), findPageUserRequest.getUuid());
                list.add(p);
            }
            // 2.用户组队的编号
            if (!StringUtils.isEmpty(findPageUserRequest.getTeamUuid())) {
                Predicate p = criteriaBuilder.equal(root.get("teamUuid"), findPageUserRequest.getTeamUuid());
                list.add(p);
            }
            // 3.组队的人数
            if (findPageUserRequest.getTeamNum() != 0) {
                Predicate p = criteriaBuilder.equal(root.get("teamNum"), findPageUserRequest.getTeamNum());
                list.add(p);
            }
            // 4.有效时间
            if (findPageUserRequest.getEffectiveTimeStart() > -1 && findPageUserRequest.getEffectiveTimeEnd() > -1) {
                Predicate p = criteriaBuilder.between(root.get("effectiveTime"),
                        findPageUserRequest.getEffectiveTimeStart(), findPageUserRequest.getEffectiveTimeEnd());
                list.add(p);
            }
            // 5.等待时间
            if (findPageUserRequest.getWaitTimeStart() > -1 && findPageUserRequest.getWaitTimeEnd() > -1) {
                Predicate p = criteriaBuilder.between(root.get("waitTime"),
                        findPageUserRequest.getWaitTimeStart(), findPageUserRequest.getWaitTimeEnd());
                list.add(p);
            }
            // 6.花费
            if (findPageUserRequest.getSpendStart() > -1 && findPageUserRequest.getSpendEnd() > -1) {
                Predicate p = criteriaBuilder.between(root.get("spend"),
                        findPageUserRequest.getSpendStart(), findPageUserRequest.getSpendEnd());
                list.add(p);
            }
            // 7.购买前行为
            if (!StringUtils.isEmpty(findPageUserRequest.getBuyBehavior())) {
                Predicate p = criteriaBuilder.like(root.get("buyBehavior"), "%" + findPageUserRequest.getBuyBehavior() +
                        "%");
                list.add(p);
            }
            // 8.穿着特征
            if (!StringUtils.isEmpty(findPageUserRequest.getWearingFeatures())) {
                Predicate p = criteriaBuilder.like(root.get("wearingFeatures"),
                        "%" + findPageUserRequest.getWearingFeatures() +
                                "%");
                list.add(p);
            }
            // 9.外貌特征
            if (!StringUtils.isEmpty(findPageUserRequest.getLooksFeatures())) {
                Predicate p = criteriaBuilder.like(root.get("looksFeatures"),
                        "%" + findPageUserRequest.getLooksFeatures() +
                                "%");
                list.add(p);
            }
            // 10.属性特征
            if (!StringUtils.isEmpty(findPageUserRequest.getAttributeFeatures())) {
                Predicate p = criteriaBuilder.like(root.get("attributeFeatures"),
                        "%" + findPageUserRequest.getAttributeFeatures() +
                                "%");
                list.add(p);
            }
            // 11.性别
            if (findPageUserRequest.getSex() != -1) {
                Predicate p = criteriaBuilder.equal(root.get("sex"), findPageUserRequest.getSex());
                list.add(p);
            }

            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };
        return userRepository.findAll(specification, pageable);
    }

    @Override
    @Async("taskExecutor")
    public void addOne(AddOneUserRequest addOneUserRequest) {
        // 购买前行为
        List<String> buyBehavior = addOneUserRequest.getBuyBehavior();
        if (addOneUserRequest.getBuyBehaviorOther() != null) {
            buyBehavior.add(addOneUserRequest.getBuyBehaviorOther());
        }
        // 穿着特征
        List<String> wearingFeatures = addOneUserRequest.getWearingFeatures();
        if (addOneUserRequest.getWearingOther() != null) {
            wearingFeatures.add(addOneUserRequest.getWearingOther());
        }
        User user = User.builder()
                .addPlaceId(addOneUserRequest.getPlaceId())
                .age(addOneUserRequest.getAgeValue())
                .sex(addOneUserRequest.getSexValue())
                .attributeFeatures(ObjectUtils.isEmpty(addOneUserRequest.getAttributeFeature()) ?
                        "" : addOneUserRequest.getAttributeFeature().toString())
                .effectiveTime(addOneUserRequest.getEffectiveTime())
                .waitTime(addOneUserRequest.getWaitTime())
                .buyBehavior(buyBehavior.toString())
                .wearingFeatures(wearingFeatures.toString())
                .isTeam(UserEnum.NO_TEAM.getCode())
                .spend(addOneUserRequest.getSpend())
                .isBuy(addOneUserRequest.getSpend() == -1 ? 0 : 1) // 如果未记录就设置为0 -> 未购买
                .occupation(addOneUserRequest.getOccupationValue())
                .looksFeatures(addOneUserRequest.getLooksFeature())
                .uuid(UniqueNumberUtils.getUserNumber(addOneUserRequest.getPlaceId()))
                .build();
        userRepository.save(user);
    }

    @Override
    @Async("taskExecutor")
    public void addMore(AddMoreUserRequest addMoreUserRequest) {
        List<User> users = new ArrayList<>(); // 提交的数据
        // 组队的队伍唯一编号，同一次记录下多个User 的该编号是一致的
        String teamNum = UniqueNumberUtils.getUserTeamNumber(addMoreUserRequest.getPlaceId(),
                addMoreUserRequest.getTeamNumber());
        // 购买前行为
        List<String> buyBehavior = addMoreUserRequest.getBuyBehavior();
        if (addMoreUserRequest.getBuyBehaviorOther() != null) {
            buyBehavior.add(addMoreUserRequest.getBuyBehaviorOther());
        }
        // 穿着特征
        List<String> wearingFeatures = addMoreUserRequest.getWearingFeatures();
        if (addMoreUserRequest.getWearingOther() != null) {
            wearingFeatures.add(addMoreUserRequest.getWearingOther());
        }
        for (int i = 0; i < addMoreUserRequest.getTeamNumber(); i++) {
            User user = User.builder()
                    .addPlaceId(addMoreUserRequest.getPlaceId())
                    .age(addMoreUserRequest.getAgeValues().get(i))
                    .sex(addMoreUserRequest.getSexValues().get(i))
                    .attributeFeatures(ObjectUtils.isEmpty(addMoreUserRequest.getAttributeFeature()) ?
                            "" : addMoreUserRequest.getAttributeFeature().toString())
                    .effectiveTime(addMoreUserRequest.getEffectiveTime())
                    .waitTime(addMoreUserRequest.getWaitTime())
                    .buyBehavior(buyBehavior.toString())
                    .wearingFeatures(wearingFeatures.toString())
                    .isTeam(UserEnum.IS_TEAM.getCode())
                    .teamNum(addMoreUserRequest.getTeamNumber())
                    .spend(addMoreUserRequest.getSpend())
                    .isBuy(addMoreUserRequest.getSpend() == -1 ? 0 : 1) // 如果未记录就设置为0 -> 未购买
                    .occupation(addMoreUserRequest.getOccupationValues().get(i))
                    .looksFeatures(addMoreUserRequest.getLooksFeatures().get(i))
                    .uuid(UniqueNumberUtils.getUserNumber(addMoreUserRequest.getPlaceId()))
                    .teamUuid(teamNum)
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    @Override
    public void modify(ModifyUserRequest modifyUserRequest) {
        Specification<User> specification = (Specification<User>) (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = criteriaBuilder.equal(root.get("uuid"), modifyUserRequest.getModifyId());
            list.add(p);
            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };
        User user = userRepository.findOne(specification).orElse(User.builder().build()); // 原对象
        // 是否删除
        if (modifyUserRequest.getModifyDelete() == UserEnum.IS_DELETE.getCode()) {
            userRepository.delete(user);
        } else {
            if (modifyUserRequest.getModifyWaitTime() != -1) {
                user.setWaitTime(modifyUserRequest.getModifyWaitTime());
            }
            if (modifyUserRequest.getModifyEffTime() != -1) {
                user.setEffectiveTime(modifyUserRequest.getModifyEffTime());
            }
            if (modifyUserRequest.getModifySpend() != -1) {
                user.setSpend(modifyUserRequest.getModifySpend());
            }
            userRepository.save(user);
        }

    }

    @Override
    public void test() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<User> users = userRepository.findAll(pageable);
        System.out.println(users.getContent());
    }
}
