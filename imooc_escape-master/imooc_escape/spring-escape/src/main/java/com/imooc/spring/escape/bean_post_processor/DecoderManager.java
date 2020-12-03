package com.imooc.spring.escape.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.imooc.spring.escape.bean_post_processor.VideoType.AVI;
import static com.imooc.spring.escape.bean_post_processor.VideoType.WMV;

@Slf4j
@Service
public class DecoderManager implements BeanPostProcessor {

    private static final Map<VideoType, IDecoder> videoTypeIndex = new HashMap<>(
            VideoType.values().length
    );

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {



        if(!(bean instanceof IDecoder)) {
            return bean;
        }
        IDecoder decoder = (IDecoder)bean;
        VideoType type = decoder.type();
        if(videoTypeIndex.containsKey(type)) {
            throw new IllegalStateException("重复注册");
        }
        log.info("加载Decoder{} from vide type{}",decoder.getClass(),type.getClass());
        videoTypeIndex.put(type, decoder);

        return null;
    }

    public String decode(VideoType type, String data){
        String result = "";
        switch (type){
            case AVI:
                result = videoTypeIndex.get(AVI).decode(data);
                break;
            case WMV:
                result = videoTypeIndex.get(WMV).decode(data);
                break;
            default:
                log.info("Error");
        }
        return result;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
