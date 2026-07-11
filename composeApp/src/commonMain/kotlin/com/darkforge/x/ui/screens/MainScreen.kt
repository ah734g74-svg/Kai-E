package com.darkforge.x.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darkforge.x.ui.theme.CyberOmegaColors

/**
 * MainScreen — الشاشة الرئيسية لـ Kai-E
 * واجهة Cyber-Omega Dark الأمامية المتطورة
 * Manus 1.6 Max Level - Premium Main UI
 */

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CyberOmegaColors.BackgroundDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            // رأس الصفحة
            HeaderSection()
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // لوحات التحكم الرئيسية
            when (selectedTab) {
                0 -> SecurityDashboard()
                1 -> SearchDashboard()
                2 -> VideoDashboard()
                3 -> FileManagerDashboard()
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        // شريط التنقل السفلي
        CustomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        CyberOmegaColors.SurfaceDark,
                        CyberOmegaColors.BackgroundDark
                    )
                )
            )
            .padding(24.dp)
    ) {
        // الشعار والعنوان
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // أيقونة الشعار
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                CyberOmegaColors.PrimaryDark,
                                CyberOmegaColors.AccentMagenta
                            )
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Kai-E Logo",
                    tint = CyberOmegaColors.BackgroundDark,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column {
                Text(
                    text = "Kai-E",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = CyberOmegaColors.PrimaryDark,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "Cyber-Omega 1.6 Max",
                    fontSize = 12.sp,
                    color = CyberOmegaColors.TextSecondary,
                    letterSpacing = 1.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // شريط البحث السريع
        SearchBar()
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text(
                "ابحث في أي مكان...",
                color = CyberOmegaColors.TextTertiary,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = CyberOmegaColors.PrimaryDark
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filter",
                tint = CyberOmegaColors.AccentCyan,
                modifier = Modifier.clickable { }
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = CyberOmegaColors.PrimaryDark,
            unfocusedBorderColor = CyberOmegaColors.BorderColor,
            focusedTextColor = CyberOmegaColors.TextPrimary,
            unfocusedTextColor = CyberOmegaColors.TextSecondary,
            focusedContainerColor = CyberOmegaColors.SurfaceLight,
            unfocusedContainerColor = CyberOmegaColors.SurfaceLight
        )
    )
}

@Composable
fun SecurityDashboard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "جناح الأمن السيبراني",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = CyberOmegaColors.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // بطاقات الأمان
        SecurityCard(
            title = "محلل الويب الشامل",
            description = "تحليل وعرض كود أي موقع",
            icon = Icons.Default.Language,
            color = CyberOmegaColors.AccentCyan
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "نظام التدقيق المطلق",
            description = "تدقيق الأكواد وضمان صحتها 100%",
            icon = Icons.Default.CheckCircle,
            color = CyberOmegaColors.AccentGreen
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "فحص الثغرات الدفاعي",
            description = "فحص وتأمين الأنظمة ضد الثغرات",
            icon = Icons.Default.Security,
            color = CyberOmegaColors.AccentMagenta
        )
    }
}

@Composable
fun SearchDashboard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "محرك البحث الشامل",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = CyberOmegaColors.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // بطاقات البحث
        SecurityCard(
            title = "البحث في الويب",
            description = "البحث السطحي والعميق",
            icon = Icons.Default.Public,
            color = CyberOmegaColors.AccentCyan
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "البحث في قواعد البيانات",
            description = "البحث في الأرشيفات العميقة",
            icon = Icons.Default.Storage,
            color = CyberOmegaColors.AccentGreen
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "البحث المتقدم",
            description = "بحث متوازي في عدة أماكن",
            icon = Icons.Default.Radar,
            color = CyberOmegaColors.AccentPurple
        )
    }
}

@Composable
fun VideoDashboard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "مركز الفيديو",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = CyberOmegaColors.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // بطاقات الفيديو
        SecurityCard(
            title = "تنزيل الفيديوهات",
            description = "سرعة تنزيل خرافية",
            icon = Icons.Default.Download,
            color = CyberOmegaColors.AccentCyan
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "ضغط الفيديو",
            description = "ضغط إلى 140p بالقوة الغاشمة",
            icon = Icons.Default.Compress,
            color = CyberOmegaColors.AccentMagenta
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "جالب المجرّة",
            description = "التقاط من أي منصة",
            icon = Icons.Default.CloudDownload,
            color = CyberOmegaColors.AccentGreen
        )
    }
}

@Composable
fun FileManagerDashboard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "مدير الملفات",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = CyberOmegaColors.TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // بطاقات الملفات
        SecurityCard(
            title = "إدارة الملفات",
            description = "وصول مطلق للملفات",
            icon = Icons.Default.FolderOpen,
            color = CyberOmegaColors.AccentCyan
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "البحث عن الملفات",
            description = "بحث سريع وفعال",
            icon = Icons.Default.Search,
            color = CyberOmegaColors.AccentGreen
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SecurityCard(
            title = "معالجة الملفات",
            description = "تعديل ونسخ ودمج",
            icon = Icons.Default.Edit,
            color = CyberOmegaColors.AccentMagenta
        )
    }
}

@Composable
fun SecurityCard(
    title: String,
    description: String,
    icon: ImageVector,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = CyberOmegaColors.SurfaceLight
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = color.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = CyberOmegaColors.TextPrimary
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = CyberOmegaColors.TextSecondary
                )
            }
            
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Navigate",
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun CustomNavigationBar(
    modifier: Modifier = Modifier,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .background(CyberOmegaColors.SurfaceDark),
        containerColor = CyberOmegaColors.SurfaceDark,
        contentColor = CyberOmegaColors.TextPrimary
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Security, contentDescription = "Security") },
            label = { Text("الأمان") },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("البحث") },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.VideoLibrary, contentDescription = "Video") },
            label = { Text("الفيديو") },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Folder, contentDescription = "Files") },
            label = { Text("الملفات") },
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) }
        )
    }
}
