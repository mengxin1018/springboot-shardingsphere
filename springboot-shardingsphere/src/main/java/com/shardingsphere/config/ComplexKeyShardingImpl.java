package com.shardingsphere.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ComplexKeyShardingImpl implements ComplexKeysShardingAlgorithm<Long> {

    /**
     * 商品表分表的个数
     */
    public final static int GOODS_TABLE_LENGTH = 2;

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        Long goodsId = Long.valueOf(shardingValue.getColumnNameAndShardingValuesMap().get("goods_id").toArray()[0].toString());
        for (String s : availableTargetNames) {
            int hash = this.getHash(goodsId);
            if(s.endsWith(hash + "")){
                List<String> list = new ArrayList<>();
                list.add(s);
                return list;
            }
        }
        throw new UnsupportedOperationException();
    }

    public int getHash(Long key){
        return key.hashCode()&(GOODS_TABLE_LENGTH-1);
    }
}
