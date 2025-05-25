#!/bin/bash

# 루트 디렉토리 (스크립트를 실행하는 위치 기준)
ROOT_DIR=$(pwd)

# 바꿀 문자열
OLD_STRING="apx8.mongoose"
NEW_STRING="apx.templatev1"

# 모든 파일 탐색 (텍스트 파일 대상으로)
find "$ROOT_DIR" -type f \( -name "*.kt" -o -name "*.java" -o -name "*.xml" -o -name "*.gradle" \) | while read -r file; do
    if grep -q "$OLD_STRING" "$file"; then
        echo "🔧 변경 중: $file"
        sed -i '' "s/$OLD_STRING/$NEW_STRING/g" "$file"
    fi
done

echo "✅ 문자열 치환 완료: '$OLD_STRING' → '$NEW_STRING'"
